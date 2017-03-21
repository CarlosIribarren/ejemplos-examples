Public Class PasahitzaBerreskuratu
    Inherits System.Web.UI.Page

  

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        '-----------------KONEXIOA-------------------------
        Try
            DBKudeatzailea.DatuAtzipena.Konektatu("C:\db\Ikasleak.mdb")
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaKonektatzean
            MsgBox("ezin da konektatu" & ex.Message)
        End Try
        '------------------------------------------------------------

        Dim emaila As String = Session("email")

        Dim gure_ikaslea As New DBKudeatzailea.Ikaslea

        Try
            gure_ikaslea = DBKudeatzailea.DatuAtzipena.IkasleaLortu(emaila)

        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
            MsgBox("ezin da ikaslea lortu" + ex.Message)
        End Try

        galderaEzkutua.Text = gure_ikaslea.galdera_ezkutua
        SetFocus(galderarenErantzuna)

        '----------------KONEXIOA ITXI------------------------------
        'Itxi konexioa
        DBKudeatzailea.DatuAtzipena.ItxiKonexioa()
        '------------------------------------------------------------

    End Sub

    

    Protected Sub Button2_Click(sender As Object, e As EventArgs) Handles EgiaztatuBotoia.Click

        '-----------------KONEXIOA-------------------------
        Try
            DBKudeatzailea.DatuAtzipena.Konektatu("C:\db\Ikasleak.mdb")
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaKonektatzean
            MsgBox("ezin da konektatu" & ex.Message)
        End Try
        '------------------------------------------------------------

        Dim erantzuna As String = galderarenErantzuna.Text
        Dim emaila As String = Session("email")

        Dim gure_ikaslea As New DBKudeatzailea.Ikaslea

        Try
            gure_ikaslea = DBKudeatzailea.DatuAtzipena.IkasleaLortu(emaila)

        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
            MsgBox("ezin da ikaslea lortu" + ex.Message)
        End Try

        If (gure_ikaslea.galdera_ezkutuaren_erantzunak = erantzuna) Then

            'EMAIL BAT BIDALI 
            'Aldagaiak definitu posta bidaltzeko
            Dim correo As New System.Net.Mail.MailMessage()
            correo.From = New System.Net.Mail.MailAddress("sgtawebgunea@gmail.com")
            correo.Subject = "SGTA-ko ikasgaiko web-gunean pasahitza berreskuratu"
            correo.To.Add(gure_ikaslea.email_helbidea)
            correo.IsBodyHtml = True
            correo.Body = "Kaixo " & gure_ikaslea.izena & " : " & "<br/><br/>SGTA-ko ikasgaiko web-guneko pasahitza hau da :" & gure_ikaslea.pasahitza & " <br/><br/>Agur."
            'Zerbitzaria konfiguratu
            Dim Servidor As New System.Net.Mail.SmtpClient
            Servidor.Host = "smtp.gmail.com"
            Servidor.Port = 587
            Servidor.EnableSsl = True
            Servidor.Credentials = New System.Net.NetworkCredential("sgtawebgunea@gmail.com", "kartel01")
            Servidor.Send(correo)

            MsgBox("Email bat bidali da pasahitzakin. Zure pasahitza hau da : " & gure_ikaslea.pasahitza, MsgBoxStyle.Information + MsgBoxStyle.SystemModal)
        Else
            MsgBox("Erantzuna ez da zuzena, saiatu berriz", MsgBoxStyle.Exclamation + MsgBoxStyle.SystemModal)
        End If

        '----------------KONEXIOA ITXI------------------------------
        'Itxi konexioa
        DBKudeatzailea.DatuAtzipena.ItxiKonexioa()
        '------------------------------------------------------------

    End Sub
    
End Class