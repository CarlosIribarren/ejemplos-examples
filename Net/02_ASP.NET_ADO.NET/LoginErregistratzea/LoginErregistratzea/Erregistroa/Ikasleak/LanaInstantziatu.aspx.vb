Imports System.Data.OleDb

Public Class LanaInstantziatu
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Dim adapterIkasleakLanak As New OleDbDataAdapter
        Dim dataSetIkasleakLanak As New DataSet
        Dim get_irak_kodea As String = Request.QueryString("LanKod")

        Dim email As String
        email = Session("email")
        TextBoxErabiltzailea.Text = Session("email")
        TextBoxLanGeneriko.Text = get_irak_kodea

        If Page.IsPostBack Then
            '2ALDITIK AURRERA

            dataSetIkasleakLanak = Session("datuMultzoa")
            adapterIkasleakLanak = Session("datuEgokitzailea")

        Else
            '1aldian
            'adapterra eskuratu
            adapterIkasleakLanak = DBKudeatzailea.DatuAtzipena.IkasleLanenEgokitzaileaEskuratu(email)
            'dataset eskuratu
            adapterIkasleakLanak.Fill(dataSetIkasleakLanak, "IkasleakLanak")

            'Datu multzoa eta datu egokitzailea sesio aldagaietan
            Session("datuMultzoa") = dataSetIkasleakLanak
            Session("datuEgokitzailea") = adapterIkasleakLanak

        End If

    End Sub

    Protected Sub ButtonLanaSortu_Click(ByVal sender As Object, ByVal e As EventArgs) Handles ButtonLanaSortu.Click
        'AurreIkusitako orduak eta BenetakOrduak bete eta Lanak Sortu botoiari eman ondoren txertatu egingo dira datu basean

        Dim dataSetIkasleakLanak As New DataSet
        dataSetIkasleakLanak = Session("datuMultzoa")

        Dim dataTableIkasleLanak As New DataTable
        dataTableIkasleLanak = dataSetIkasleakLanak.Tables("IkasleakLanak")

        Dim bistaIkasleLanak As DataView
        bistaIkasleLanak = New DataView(dataTableIkasleLanak)
        
        bistaIkasleLanak.RowFilter = "lanGenerikoarenKodea LIKE '" & TextBoxLanGeneriko.Text & "*'"

        'Sarturiko irakasgai kodearekin ez badago lanik asignaturik txertatu taulan 
        If (bistaIkasleLanak.Count = 0) Then

            Dim errenkada As DataRow
            errenkada = dataTableIkasleLanak.NewRow()
            errenkada("email") = TextBoxErabiltzailea.Text
            errenkada("lanGenerikoarenKodea") = TextBoxLanGeneriko.Text
            errenkada("aurreikusitakoOrduak") = TextBoxAurreIkOrduak.Text
            errenkada("benetakoOrduak") = TextBoxBenetakoOrduak.Text
            dataTableIkasleLanak.Rows.Add(errenkada)

            'IkasleakLanak taulan 4 erregistroetan idatzirik errenkada berri bat sortu eta taulan txertatuko da, gero eguneratu egingo da datu basea Update aginduaren bitartez
            Dim konexioa As OleDbConnection
            konexioa = Session("konexioa")

            'insert komandoa definitu
            Dim insertKomandoa As New OleDbCommand
            insertKomandoa = New OleDbCommand("INSERT INTO IkasleakLanak " & "(email, lanGenerikoarenKodea, aurreikusitakoOrduak, benetakoOrduak) " & _
                                            "VALUES ('" & TextBoxErabiltzailea.Text & "' , '" & TextBoxLanGeneriko.Text & "' ," & TextBoxAurreIkOrduak.Text & " ," & TextBoxBenetakoOrduak.Text & ")", konexioa)

            Dim adapterIkasleakLanak As New OleDbDataAdapter
            adapterIkasleakLanak = Session("datuEgokitzailea")

            'insert komandoa sortu gero DataAdapterrari asignatzeko 
            adapterIkasleakLanak.InsertCommand = insertKomandoa
            adapterIkasleakLanak.Update(dataSetIkasleakLanak, "IkasleakLanak")
            dataSetIkasleakLanak.AcceptChanges()

            Session("datuMultzoa") = dataSetIkasleakLanak
            Session("datuEgokitzailea") = adapterIkasleakLanak

            MsgBox("Dena ondo joan da", MsgBoxStyle.SystemModal + MsgBoxStyle.Information)

            SaretaIkasleLanak.DataBind()
            TextBoxAurreIkOrduak.Text = ""
            TextBoxBenetakoOrduak.Text = ""

        Else

            MsgBox("Ezin da lana sortu, lanaren erregistro bat badago", MsgBoxStyle.Critical)

        End If
        
    End Sub

End Class