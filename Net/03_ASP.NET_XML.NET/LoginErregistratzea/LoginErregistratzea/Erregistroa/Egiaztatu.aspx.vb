Public Class Egiaztatu
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        'get datua eskuratu
        Dim get_Email As String = Request.QueryString("erab")
        Dim get_Zenb As String = Request.QueryString("egZenb")
        '-----------------KONEXIOA-------------------------
        Try
            DBKudeatzailea.DatuAtzipena.Konektatu(Server.MapPath("~/Datu_Basea/SGTA_DB.mdb"))
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaKonektatzean
            MsgBox("ezin da konektatu" & ex.Message)
        End Try
        '------------------------------------------------------------

        Dim gure_ikaslea As New DBKudeatzailea.Ikaslea

        Try
            gure_ikaslea = DBKudeatzailea.DatuAtzipena.IkasleaLortu(get_Email)

        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
            MsgBox("ezin da ikaslea lortu" + ex.Message)
        End Try

        If (gure_ikaslea.egiaztatze_zenbakia = get_Zenb) Then
            'zenbakiak berdinak dira, orain egiaztatua true jarriko da
            Try
                DBKudeatzailea.DatuAtzipena.ikasleaEgiaztatu(get_Email)

            Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
                MsgBox("ezin da ikaslea lortu" + ex.Message)
            End Try

            LabelMezua.Text = "erabiltzailea " & get_Email & " ondo aktibatu da!! "

        Else
            'egiaztatzen zenbakiak ez dira zuzenak
            LabelMezua.Text = "erabiltzailea " & get_Email & " ez da aktibatu. ( Errorea : aktibatze zenbakiak ez dira berdinak ) "

        End If

        '----------------KONEXIOA ITXI------------------------------
        'Itxi konexioa
        DBKudeatzailea.DatuAtzipena.ItxiKonexioa()
        '------------------------------------------------------------
    End Sub

End Class