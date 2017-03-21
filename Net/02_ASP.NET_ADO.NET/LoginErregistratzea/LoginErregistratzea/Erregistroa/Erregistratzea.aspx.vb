Public Class Erregistratzea
    Inherits System.Web.UI.Page

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As EventArgs) Handles ButtonErregistratu.Click
        '-----------------KONEXIOA-------------------------
        Try
            DBKudeatzailea.DatuAtzipena.Konektatu(Server.MapPath("~/Datu_Basea/SGTA_DB.mdb"))
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaKonektatzean
            MsgBox("ezin da konektatu" & ex.Message)
        End Try
        '------------------------------------------------------------

        'datuak eskuratu
        Dim email As String = TextBoxEmail.Text
        Dim izena As String = TextBoxIzena.Text
        Dim abizena As String = TextBoxAbizena.Text
        Dim pass As String = TextBoxPasahitza.Text
        Dim galderaEzkutua As String = TextBoxGalderaEzkutua.Text
        Dim galderaEzkutuarenErantzuna As String = TextBoxGalderarenErantzuna.Text
        Dim erabiltzaileMota As String = TextBoxErabiltzaileMota.Text
        Dim egiaztatua As Boolean = False
        'egiaztatze zenbakia kalkulatu
        Dim egiaztatzenZenbakia As Integer
        Randomize()
        egiaztatzenZenbakia = CLng(Rnd() * 9000000) + 1000000

        'ikasle berria sortu
        Dim ikasleBerria As New DBKudeatzailea.Ikaslea
        ikasleBerria.email_helbidea = email
        ikasleBerria.izena = izena
        ikasleBerria.abizena = abizena
        ikasleBerria.pasahitza = pass
        ikasleBerria.galdera_ezkutua = galderaEzkutua
        ikasleBerria.galdera_ezkutuaren_erantzunak = galderaEzkutuarenErantzuna
        ikasleBerria.egiaztatze_zenbakia = egiaztatzenZenbakia
        ikasleBerria.egiaztatua = egiaztatua
        ikasleBerria.erabiltzaileMota = erabiltzaileMota

        'ikasle berria gorde
        Try
            MsgBox(erabiltzaileMota)
            DBKudeatzailea.DatuAtzipena.IkasleaTxertatu(ikasleBerria)

            HyperLinkEgiaztatu.Visible = True

            Dim urlKatea As String
            urlKatea = "http://localhost:52668/Erregistroa/Egiaztatu.aspx?erab=" & email & "&egZenb=" & egiaztatzenZenbakia
            HyperLinkEgiaztatu.NavigateUrl = urlKatea

            'EMAIL BAT BIDALI KONFIRMATZEKO
            'Aldagaiak definitu posta bidaltzeko
            Dim correo As New System.Net.Mail.MailMessage()
            correo.From = New System.Net.Mail.MailAddress("sgtawebgunea@gmail.com")
            correo.Subject = "SGTA-ko ikasgaiko web-gunean erregistratoa"
            correo.To.Add(email)
            correo.IsBodyHtml = True
            correo.Body = "Kaixo " & izena & " : " & "<br/><br/>SGTA-ko ikasgaiko web-gunean erregistratu zara.<br/><br/> Mesedez esteka honetan <a href =""" & urlKatea & """ > " & urlKatea & "  </a>  click egin erregistroa egiaztatzeko."
            'Zerbitzaria konfiguratu
            Dim Servidor As New System.Net.Mail.SmtpClient
            Servidor.Host = "smtp.gmail.com"
            Servidor.Port = 587
            Servidor.EnableSsl = True
            Servidor.Credentials = New System.Net.NetworkCredential("sgtawebgunea@gmail.com", "kartel01")
            Servidor.Send(correo)

            MsgBox("Erabiltzaile berria ondo gorde da. Kontua egiaztatzeko zure posta helbidera mezu bat bidali da.", MsgBoxStyle.SystemModal + MsgBoxStyle.Information)


        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaTxertatzean
            MsgBox("Ezin da ikaslea txertatu" + ex.Message)
        End Try

        '----------------KONEXIOA ITXI------------------------------
        'Itxi konexioa
        DBKudeatzailea.DatuAtzipena.ItxiKonexioa()
        '------------------------------------------------------------
    End Sub


    Protected Sub Page_Load(ByVal sender As Object, ByVal e As EventArgs) Handles Me.Load
        SetFocus(TextBoxEmail)
    End Sub

  
End Class