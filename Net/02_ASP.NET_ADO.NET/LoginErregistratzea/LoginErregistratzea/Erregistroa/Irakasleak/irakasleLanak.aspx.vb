Public Class irakasleLanak
    Inherits System.Web.UI.Page


    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As EventArgs) Handles Button1.Click
        Response.Redirect("~/Erregistroa/Irakasleak/LanGenerikoakGehitu.aspx")
    End Sub

    Protected Sub LinkButton1_Click(ByVal sender As Object, ByVal e As EventArgs) Handles LinkButtonBukatuSaioa.Click
        Session.Abandon()
    End Sub

End Class