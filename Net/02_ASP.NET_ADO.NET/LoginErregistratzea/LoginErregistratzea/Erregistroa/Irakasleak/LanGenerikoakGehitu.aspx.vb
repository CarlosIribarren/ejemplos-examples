Imports System.Data.OleDb

Public Class LanGenerikoakGehitu
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Dim adapterLanGenerikoak As New OleDbDataAdapter
        Dim dataSetLanGenerikoak As New DataSet

        If Page.IsPostBack = False Then
            'lehenengo aldian bakarrik 

            'Mota Dropbown-a Lan Motaz bete
            DropDownListMota.Items.Add("azterketa")
            DropDownListMota.Items.Add("laborategia")
            DropDownListMota.Items.Add("lana")

            adapterLanGenerikoak = DBKudeatzailea.DatuAtzipena.LanGenerikoenEgokitzaileaEskuratu()

            adapterLanGenerikoak.Fill(dataSetLanGenerikoak, "LanGenerikoak")

            Session("DatuEgokitzailea") = adapterLanGenerikoak
            Session("DatuMultzoa") = dataSetLanGenerikoak

        Else
            adapterLanGenerikoak = Session("DatuEgokitzailea")
            dataSetLanGenerikoak = Session("DatuMultzoa")
        End If


    End Sub

    Protected Sub ButtonGehituLana_Click(ByVal sender As Object, ByVal e As EventArgs) Handles ButtonGehituLana.Click

        Dim adapterLanGenerikoak As New OleDbDataAdapter
        adapterLanGenerikoak = Session("DatuEgokitzailea")
        Dim dataSetLanGenerikoak As New DataSet
        dataSetLanGenerikoak = Session("DatuMultzoa")
        Dim dataTableLanGenerikoak As New DataTable
        dataTableLanGenerikoak = dataSetLanGenerikoak.Tables("LanGenerikoak")

        Dim bistaIkasleLanak As DataView
        bistaIkasleLanak = New DataView(dataTableLanGenerikoak)

        bistaIkasleLanak.RowFilter = "kodea LIKE '" & TextBoxKodea.Text & "*'"

        If bistaIkasleLanak.Count = 0 Then
            'errenkada ez da aurkitu

            'errenkada bat sortu
            Dim errenkada As DataRow
            errenkada = dataTableLanGenerikoak.NewRow()
            errenkada("kodea") = TextBoxKodea.Text
            errenkada("deskribapena") = TextBoxDeskribapena.Text
            errenkada("irakasgaiKodea") = DropDownListIrakasgaia.Text
            errenkada("aurreikusitakoOrduak") = TextBoxOrduak.Text
            errenkada("lanMota") = DropDownListMota.Text
            dataTableLanGenerikoak.Rows.Add(errenkada)
            'komando guztiak definitu
            Dim builder As New OleDbCommandBuilder(adapterLanGenerikoak)
            'db update egin
            adapterLanGenerikoak.Update(dataSetLanGenerikoak, "LanGenerikoak")
            'dataset eta adapterra hasieratu
            dataSetLanGenerikoak.AcceptChanges()
            'aldaketak gorde
            Session("DatuEgokitzailea") = adapterLanGenerikoak
            Session("DatuMultzoa") = dataSetLanGenerikoak

            'mezua bistaratu eta eremua garbitu
            MsgBox("Ondo gorde da!", MsgBoxStyle.Information + MsgBoxStyle.SystemModal)
            TextBoxKodea.Text = ""
            TextBoxDeskribapena.Text = ""
            TextBoxOrduak.Text = ""
            SetFocus(TextBoxKodea)
        Else
            'errenkada existitzen da
            MsgBox("Lan Generikoaren kodea existitzen da, mesedez beste bat sartu", vbCritical + vbSystemModal)

        End If



    End Sub
End Class