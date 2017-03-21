Imports System.Xml
Imports System.Data.OleDb

Public Class InportatuLanakXml
    Inherits System.Web.UI.Page

    Private Sub DropDownList1_DataBound(ByVal sender As Object, ByVal e As System.EventArgs) Handles DropDownList1.DataBound
        xmlKargatu()
    End Sub

    Protected Sub DropDownList1_SelectedIndexChanged(ByVal sender As Object, ByVal e As EventArgs) Handles DropDownList1.SelectedIndexChanged
        xmlKargatu()
    End Sub

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As EventArgs) Handles Button1.Click

        'XML DOKUMENTUA KARGATU
        Dim Dokumentua As XmlDocument = New XmlDocument
        Try
            'xml dokumentua kargatu eta defektuz balidatu
            Dokumentua.Load(Server.MapPath("~/Datu_Basea/" & DropDownList1.SelectedValue & ".xml"))

        Catch ex As Exception
            MsgBox("xml gaizki eratuta dago!!", vbCritical)
        End Try

        'LAN GENERIKOEN ADAPTERRA ETA DATASETA DATURIK GABE ESKURATU
        Dim adapterLanGenerikoak As New OleDbDataAdapter
        adapterLanGenerikoak = DBKudeatzailea.DatuAtzipena.LanGenerikoenEgokitzaileaEskuratu()
        Dim dataSetLanGenerikoak As New DataSet
        adapterLanGenerikoak.Fill(dataSetLanGenerikoak, "LanGenerikoak")
        Dim dataTableLanGenerikoak As New DataTable
        dataTableLanGenerikoak = dataSetLanGenerikoak.Tables("LanGenerikoak")

        'ORAIN DATASET-EAN EZ DAUDEN ERREKENKADAK XML-TIK KOPIATU ( XML -> DATASET )

        'XML KORRITU
        Dim lanakLista As XmlNodeList
        'XML-KO "lana" ELEMENTUAK LISTA ESKURATU
        lanakLista = Dokumentua.GetElementsByTagName("lana")
        'LANA LISTA KORRITU
        For i As Integer = 0 To lanakLista.Count - 1

            'ESKURATU LAN KODEA
            Dim xmlLANKODEA As String = lanakLista(i).Item("kodea").ChildNodes(0).Value

            'BEGIRATU KODEA DATASET-EAN EXISTITZEN DEN
            Dim lanErrenkedaBat As DataRow()
            'BEGIRATU EA ERRENKADA EXISTIZEN DEN
            lanErrenkedaBat = dataTableLanGenerikoak.Select("kodea = '" & xmlLANKODEA & "'")
            'EZ BADA EXISTITZEN
            If lanErrenkedaBat.Length < 1 Then

                MsgBox("ez dago kode hau db: " & xmlLANKODEA)
                'ERRENKADA BERRI SORTU DATU BASEKO EREMUEKIN
                Dim rowBerria As DataRow = dataTableLanGenerikoak.NewRow()
                'ERRENKADARI BALIO BERRIAK EMAN
                rowBerria("kodea") = lanakLista(i).Item("kodea").ChildNodes(0).Value
                rowBerria("deskribapena") = lanakLista(i).Item("deskribapena").ChildNodes(0).Value
                rowBerria("irakasgaiKodea") = DropDownList1.SelectedValue
                rowBerria("aurreikusitakoOrduak") = lanakLista(i).Item("aurreikusitakoOrduak").ChildNodes(0).Value
                rowBerria("ustiapenean") = lanakLista(i).Item("ustiapenean").ChildNodes(0).Value
                rowBerria("lanMota") = lanakLista(i).Item("lanMota").ChildNodes(0).Value
                'ERRENKADA BERRI GEHITU
                dataTableLanGenerikoak.Rows.Add(rowBerria)

            End If

        Next

        Dim aldatutakoKOP As Integer = 0
        'KOMANDO GUZTIAK DEFINITU
        Dim builder As New OleDbCommandBuilder(adapterLanGenerikoak)
        'AZKENIK DATASET EGUNERATUA DATU BASEAN GORDE
        aldatutakoKOP = adapterLanGenerikoak.Update(dataSetLanGenerikoak, "LanGenerikoak")
        dataSetLanGenerikoak.AcceptChanges()
        MsgBox("Aldaketak ondo gorde dira, " & aldatutakoKOP & " erregistro gehitu dira")

    End Sub

    Protected Sub xmlKargatu()

        'irakasgai kodearen arabera dagokion xml eta xsd kargatu
        Dim xmlHelbidea, xslt_Helbidea, eskemaHelbidea As String
        'XML
        xmlHelbidea = Server.MapPath("~/Datu_Basea/" & DropDownList1.SelectedValue & ".xml")
        'XSD
        eskemaHelbidea = Server.MapPath("~/Datu_Basea/" & DropDownList1.SelectedValue & ".xsd")
        'XSLT OROKORRA
        xslt_Helbidea = Server.MapPath("~/Datu_Basea/lanakHTMLratu.xsl")
        If (System.IO.File.Exists(xmlHelbidea)) Then

            If (xmlOngiEratutaDago(xmlHelbidea)) Then
                'xml kontrolari dagokion xml ezarri
                XmlKontrola.DocumentSource = xmlHelbidea
                'xml kontrolari xslt orokorra ezarriko diogu ( xml guztientzako balio du)
                XmlKontrola.TransformSource = xslt_Helbidea
            Else
                MsgBox("xml ez dago ongi eratuta!!")
            End If

        Else
            MsgBox("xml fitxategia ez da existitzen!!", vbCritical)
        End If

    End Sub

    'XML Ongi eratuta dauden jakiteko funtzioa ( True / False )
    Protected Function xmlOngiEratutaDago(ByRef helbidea As String) As Boolean
        Dim erantzuna As Boolean
        erantzuna = True
        Dim Dokumentua As XmlDocument = New XmlDocument
        Try
            'xml ongi eratuta dagoen ikusteko, kargatzen(Load) saiatzen da   
            Dokumentua.Load(helbidea)
        Catch ex As Exception
            erantzuna = False
        End Try
        Return erantzuna
    End Function

End Class

