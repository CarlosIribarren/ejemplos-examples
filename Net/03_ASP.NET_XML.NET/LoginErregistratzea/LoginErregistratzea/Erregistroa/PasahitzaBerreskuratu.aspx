<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="PasahitzaBerreskuratu.aspx.vb" Inherits="LoginErregistratzea.PasahitzaBerreskuratu" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Label ID="Label1" runat="server" Font-Size="XX-Large" 
            Font-Underline="True" 
            style="z-index: 1; left: 315px; top: 34px; position: absolute; width: 461px" 
            Text="Pasahitza Berreskuratu"></asp:Label>
    
    </div>
        <p>
            &nbsp;</p>
        <p>
            &nbsp;</p>
        <p>
            &nbsp;</p>
        <p>
            <asp:Label ID="LabelErantzuna" runat="server" 
                style="z-index: 1; left: 350px; top: 186px; position: absolute" 
                Text="Erantzuna"></asp:Label>
        </p>
        <p>
            <asp:Label ID="LabelGaldera" runat="server" 
                style="z-index: 1; left: 312px; top: 147px; position: absolute" 
                Text="Galdera ezkutua"></asp:Label>
            <asp:TextBox ID="galderaEzkutua" runat="server" 
                style="z-index: 1; left: 442px; top: 147px; position: absolute; width: 456px;" 
                Enabled="False" ReadOnly="True"></asp:TextBox>
            <asp:TextBox ID="galderarenErantzuna" runat="server" style="z-index: 1; left: 439px; top: 184px; position: absolute; width: 265px"></asp:TextBox>
        </p>
        <p>
            <asp:Button ID="EgiaztatuBotoia" runat="server" style="z-index: 1; left: 455px; top: 260px; position: absolute; width: 114px" Text="Egiaztatu" />
            <asp:HyperLink ID="LinkLogin" runat="server" 
                NavigateUrl="~/Erregistroa/Login.aspx" 
                style="z-index: 1; left: 638px; top: 262px; position: absolute">Login Orria</asp:HyperLink>
        </p>
    </form>
</body>
</html>
