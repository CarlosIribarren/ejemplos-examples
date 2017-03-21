Imports System.Data.OleDb
Imports System.Xml

Public Class EsportatuLanak
    Inherits System.Web.UI.Page

    Private Sub DropDownList1_DataBound(ByVal sender As Object, ByVal e As System.EventArgs) Handles DropDownList1.DataBound
        datuakKargatu()
    End Sub

    Protected Sub DropDownList1_SelectedIndexChanged(ByVal sender As Object, ByVal e As EventArgs) Handles DropDownList1.SelectedIndexChanged
        datuakKargatu()
    End Sub

    Protected Sub datuakKargatu()
        'LAN GENERIKOEN ADAPTERRA ETA DATASETA ESKURATU
        Dim adapterLanGenerikoak As New OleDbDataAdapter
        adapterLanGenerikoak = DBKudeatzailea.DatuAtzipena.LanGenerikoenEgokitzaileaEskuratu()
        Dim dataSetLanGenerikoak As New DataSet
        adapterLanGenerikoak.Fill(dataSetLanGenerikoak, "LanGenerikoak")
        Dim dataTableLanGenerikoak As New DataTable
        dataTableLanGenerikoak = dataSetLanGenerikoak.Tables("LanGenerikoak")

        'DATAVIEW obj sortu
        Dim dataBista = New DataView(dataTableLanGenerikoak)
        'dataView filtroa aplikatu irakasgaia batenak agertzeko
        dataBista.RowFilter = "irakasgaiKodea = '" & DropDownList1.SelectedValue & "'"

        'GRIDVIEW datuak bistarenak eman
        GridView1.DataSource = dataBista

        'gridview BISTA lotu
        GridView1.DataBind()


    End Sub

    Protected Sub Esportatu_Click(ByVal sender As Object, ByVal e As EventArgs) Handles Esportatu.Click
        Dim adapterLanGenerikoak As New OleDbDataAdapter
        adapterLanGenerikoak = DBKudeatzailea.DatuAtzipena.LanGenerEgokitEskuratuIrakasgaiKodearekin(DropDownList1.SelectedValue)
        Dim dataSetLanGenerikoak As New DataSet
        'bigarrengo parametroa (1,2) lana, taularen izena finkatzen du dataset-ean
        'XML-an 
        adapterLanGenerikoak.Fill(dataSetLanGenerikoak, "lana")
        'dataset izena XML-ko erroaren izena finkatzen du
        dataSetLanGenerikoak.DataSetName = "lanGenerikoak"
        'XML fitxategia sortu
        dataSetLanGenerikoak.WriteXml(Server.MapPath("~/Datu_Basea/" & DropDownList1.SelectedValue & ".xml"))

        'HOBEKUNTZA
        'XML DOKUMENTUA KARGATU
        Dim Dokumentua As XmlDocument = New XmlDocument
        Try
            'xml dokumentua kargatu eta defektuz balidatu
            Dokumentua.Load(Server.MapPath("~/Datu_Basea/" & DropDownList1.SelectedValue & ".xml"))


        Catch ex As Exception
            MsgBox("xml gaizki eratuta dago!!", vbCritical)
        End Try

        ' ---------------------------------------------------------------------------------------------
        'ATRIBUTU BERRI BAT TXERTATU XML-AN 
        'Erroa lortu
        Dim nodeErroa As XmlElement = Dokumentua.SelectSingleNode("//lanGenerikoak")
        'Atributua erazagutu
        Dim atributua As XmlAttribute
        'Atributuan sartu behar den textua
        Dim textuNodoa As XmlText = Dokumentua.CreateTextNode("http://ji.ehu.es/" & DropDownList1.SelectedValue)

        'Atributua sortu xml-rako
        atributua = Dokumentua.CreateAttribute("xmlns:" & DropDownList1.SelectedValue)
        'Atributuan textua txertatua
        atributua.AppendChild(textuNodoa)
        'Erroan atributua txertatu
        nodeErroa.Attributes.Append(atributua)
        '---------------------------------------------------------------------------------------------------

        '----------------------------------------------------------------------------------------------------
        'IRAKASGAI KODEA LANA NODOAREN UME GUZTIETATIK EZABATU
        'node lista bat eskuratu dagokion posizioan
        Dim nodeList As XmlNodeList = Dokumentua.SelectNodes("//lana")
        'node bakoitzarentzako irakasgaikodea semea ezabatu (<irakasgaikodea>AAA</irakasgaikodea>)

        For Each node In nodeList
            node.RemoveChild(node.SelectSingleNode("irakasgaiKodea"))
        Next
        '----------------------------------------------------------------------------------------------------

        'berriro XML fitxategia gorde
        Dokumentua.Save(Server.MapPath("~/Datu_Basea/" & DropDownList1.SelectedValue & ".xml"))

        MsgBox(Server.MapPath("~/XML/" & DropDownList1.SelectedValue & ".xml") & " fitxategia sortu egin da!!")
    End Sub
End Class