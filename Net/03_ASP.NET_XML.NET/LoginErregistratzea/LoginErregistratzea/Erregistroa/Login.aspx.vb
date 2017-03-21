Imports System.Data.OleDb

Public Class WebForm1
    Inherits System.Web.UI.Page

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As EventArgs) Handles ButtonSartu.Click

        '-----------------KONEXIOA-------------------------
        Dim konexioa As OleDbConnection
        Try

            konexioa = DBKudeatzailea.DatuAtzipena.Konektatu(Server.MapPath("~/Datu_Basea/SGTA_DB.mdb"))
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaKonektatzean
            MsgBox("ezin da konektatu" & ex.Message, vbCritical + vbSystemModal)
            konexioa = New OleDbConnection
        End Try
        '------------------------------------------------------------

        Dim email As String = TextBoxEmail.Text
        Dim pass As String = TextBoxPasahitza.Text

        Dim gure_ikaslea As New DBKudeatzailea.Ikaslea

        Try
            gure_ikaslea = DBKudeatzailea.DatuAtzipena.IkasleaLortu(email)

        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
            MsgBox("ezin da ikaslea lortu" + ex.Message)
        End Try

        If (gure_ikaslea.email_helbidea = email) Then
            'erabiltzailea aurkitu da, ORAIN pasahitza begiratu
            If (gure_ikaslea.pasahitza = pass) Then
                Session("email") = TextBoxEmail.Text
                Session("konexioa") = konexioa
                Dim katea As String
                katea = "~/Erregistroa/" & gure_ikaslea.erabiltzaileMota & "k/" & gure_ikaslea.erabiltzaileMota & "k.aspx"
                Response.Redirect(katea)
            Else
                ' PASAHITZA OKERRA
                MsgBox("Pasahitza desegokia!!!", MsgBoxStyle.Critical)
                TextBoxPasahitza.Text = ""
                SetFocus(TextBoxPasahitza)
            End If

        Else
            'EZ DA ERABILTZAILEA EXISTITZEN
            MsgBox("Ez da Erabiltzailea existitzen!!!", MsgBoxStyle.Critical)
            TextBoxEmail.Text = ""
            TextBoxPasahitza.Text = ""

        End If

        '----------------KONEXIOA ITXI------------------------------
        'Itxi konexioa
        DBKudeatzailea.DatuAtzipena.ItxiKonexioa()
        '-----------------------------------------------------------
    End Sub

    Protected Sub LinkButton2_Click(ByVal sender As Object, ByVal e As EventArgs) Handles LinkButtonBerreskuratu.Click
        Session("email") = TextBoxEmail.Text
        Response.Redirect("~/Erregistroa/PasahitzaBerreskuratu.aspx")
    End Sub

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As EventArgs) Handles Me.Load
        SetFocus(TextBoxEmail)
    End Sub

    Protected Sub TextBoxEmail_TextChanged(ByVal sender As Object, ByVal e As EventArgs) Handles TextBoxEmail.TextChanged

    End Sub
End Class