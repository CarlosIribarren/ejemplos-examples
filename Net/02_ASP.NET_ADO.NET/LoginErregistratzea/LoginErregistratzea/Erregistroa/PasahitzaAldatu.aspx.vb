Public Class PasahitzaAldatu
    Inherits System.Web.UI.Page

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As EventArgs) Handles ButtonAldatu.Click
        '-----------------KONEXIOA-------------------------
        Try
            DBKudeatzailea.DatuAtzipena.Konektatu(Server.MapPath("~/Datu_Basea/SGTA_DB.mdb"))
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaKonektatzean
            MsgBox("ezin da konektatu" & ex.Message)
        End Try
        '------------------------------------------------------------

        'UNEKO IKASLEA LORTU SESSION EGITURAREKIN
        Dim uneko_emaila As String = Session("email")
        Dim gure_ikaslea As New DBKudeatzailea.Ikaslea
        Try
            gure_ikaslea = DBKudeatzailea.DatuAtzipena.IkasleaLortu(uneko_emaila)

        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
            MsgBox("ezin da ikaslea lortu" + ex.Message)
        End Try

        '----------------KONEXIOA ITXI------------------------------
        'Itxi konexioa
        DBKudeatzailea.DatuAtzipena.ItxiKonexioa()
        '------------------------------------------------------------


        ' ERABILTZAILEAREN PASAHITZA ETA SARTUTAKOA BERDINAK BADIRA
        If (gure_ikaslea.pasahitza = pasahitza.Text) Then

            '-----------------KONEXIOA-------------------------
            Try
                DBKudeatzailea.DatuAtzipena.Konektatu(Server.MapPath("~/Datu_Basea/SGTA_DB.mdb"))
            Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaKonektatzean
                MsgBox("ezin da konektatu" & ex.Message)
            End Try
            '-----------------------------------------------------------

            Try
                DBKudeatzailea.DatuAtzipena.ikaslearenPasahitzaAldatu(uneko_emaila, pasahitzBerria1.Text)
                MsgBox("Pasahitza ongi aldatu da. Zure pasahitz berria hau da : " & pasahitzBerria1.Text, MsgBoxStyle.SystemModal + MsgBoxStyle.Information)
            Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaikaslearenPasahitzaAldatu
                MsgBox("ez da ikaslearen pasahitza aldatu" + ex.Message)
            End Try

            pasahitza.Text = ""
            pasahitzBerria1.Text = ""
            pasahitzBerria2.Text = ""

            '----------------KONEXIOA ITXI------------------------------
            'Itxi konexioa
            DBKudeatzailea.DatuAtzipena.ItxiKonexioa()
            '------------------------------------------------------------
        Else
            MsgBox("Sartu duzun pasahitza ez da egokia", MsgBoxStyle.Critical)
            pasahitza.Text = ""
            SetFocus(pasahitza)
        End If

    End Sub

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As EventArgs) Handles Me.Load
        SetFocus(pasahitza)
    End Sub
End Class