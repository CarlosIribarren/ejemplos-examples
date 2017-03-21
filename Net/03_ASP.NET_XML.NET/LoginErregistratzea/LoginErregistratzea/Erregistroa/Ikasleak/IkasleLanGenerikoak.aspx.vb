Imports System.Data.OleDb
Imports System.Data

Public Class IkasleLanGenerikoak
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Dim dataSetOrokorra As New DataSet

        If IsPostBack = False Then
            'lehenengo aldian bakarrik

            '----------------------------- KODE LISTA BETE ----------------------------------------
            'adapterra definitu
            Dim dataAdapter As New OleDbDataAdapter
            'datu egokitzailea(data adapterra) jasoko da  
            dataAdapter = DBKudeatzailea.DatuAtzipena.IkasleaMatrikulatutakoIrakasgaienEgokitzaileaEskuratu(Session("email"))
            'DB DATUAK EKARRI
            dataAdapter.Fill(dataSetOrokorra, "KlasekoTaldeak")

            'KlasekoTaldeak  datu baseko taula betetzeko taula berria
            Dim datatable As DataTable
            datatable = dataSetOrokorra.Tables("KlasekoTaldeak")

            'lista hedagarriak KlasekoTaldeak taulako irakasgaiKodea zutabeko elementuak txertatzen dira 
            For Each rowMbr In datatable.Rows
                kodeLista.Items.Add(rowMbr("irakasgaiKodea"))
            Next

            '---------------------------- LAN GENERIKOAK ESKURATU ---------------------------------
            'Lan Generikoak taulako 3 zutabe deskribapena,kode eta aurreikusitakoOrduak
            dataAdapter = DBKudeatzailea.DatuAtzipena.UstiapenekoLanGenerikoenEgokitzaileaEskuratu()
            'dataSet datuez bete
            dataAdapter.Fill(dataSetOrokorra, "LanGenerikoak")
            'SESION aldagaiean gorde
            Session("Datuak") = dataSetOrokorra

        Else

            '2 alditik aurrera
            dataSetOrokorra = Session("Datuak")

        End If

    End Sub

    Private Sub GridView1_Sorting(ByVal sender As Object, ByVal e As System.Web.UI.WebControls.GridViewSortEventArgs) Handles GridView1.Sorting
        Dim dataBista As New DataView()
        dataBista = Session("bista")
        dataBista.Sort = e.SortExpression
        GridView1.DataSource = dataBista
        GridView1.DataBind()
    End Sub


    Protected Sub GridView1_SelectedIndexChanged(ByVal sender As Object, ByVal e As EventArgs) Handles GridView1.SelectedIndexChanged
        Dim kodea As String = GridView1.Rows(GridView1.SelectedIndex).Cells(1).Text
        Response.Redirect("~/Erregistroa/Ikasleak/LanaInstantziatu.aspx?LanKod=" & kodea)
    End Sub


    Public Sub taulaEguneratu()
        Dim dataSetOrokorra As New DataSet
        'LAN GENERIKOAK datuak eskuratu
        dataSetOrokorra = Session("Datuak")

        'DATATABLE obj sortu
        Dim dataTable As DataTable
        'dataTable obj datuez bete
        dataTable = dataSetOrokorra.Tables("LanGenerikoak")

        'DATAVIEW obj sortu
        Dim dataBista = New DataView(dataTable)
        'dataView filtroa aplikatu irakasgaia batenak agertzeko
        dataBista.RowFilter = "irakasgaiKodea = '" & kodeLista.SelectedValue & "'"

        'GridView(egitura >= kodea,deskribapena,aurreikusitakoOrduak,lanMota,irakasgaiKodea
        GridView1.Columns(2).Visible = CheckBoxDeskribapena.Checked
        GridView1.Columns(3).Visible = CheckBoxAurreikOrd.Checked
        GridView1.Columns(4).Visible = CheckBoxLanMota.Checked
        GridView1.Columns(5).Visible = False

        'GRIDVIEW datuak bistarenak eman
        GridView1.DataSource = dataBista

        'gridview BISTA lotu
        GridView1.DataBind()

        'bista session gorde
        Session("bista") = dataBista
    End Sub

    Private Sub Button1_Click1(ByVal sender As Object, ByVal e As EventArgs) Handles Button1.Click
        taulaEguneratu()
    End Sub


    Protected Sub kodeLista_SelectedIndexChanged(ByVal sender As Object, ByVal e As EventArgs) Handles kodeLista.SelectedIndexChanged
        taulaEguneratu()
    End Sub

    Protected Sub CheckBoxDeskribapena_CheckedChanged(ByVal sender As Object, ByVal e As EventArgs) Handles CheckBoxDeskribapena.CheckedChanged
        taulaEguneratu()
    End Sub

    Protected Sub CheckBoxAurreikOrd_CheckedChanged(ByVal sender As Object, ByVal e As EventArgs) Handles CheckBoxAurreikOrd.CheckedChanged
        taulaEguneratu()
    End Sub

    Protected Sub CheckBoxLanMota_CheckedChanged(ByVal sender As Object, ByVal e As EventArgs) Handles CheckBoxLanMota.CheckedChanged
        taulaEguneratu()
    End Sub
End Class