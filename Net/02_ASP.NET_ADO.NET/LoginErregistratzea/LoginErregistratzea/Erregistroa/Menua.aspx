<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Menua.aspx.vb" Inherits="LoginErregistratzea.Menua" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Label ID="Label1" runat="server" Font-Overline="False" 
            Font-Size="XX-Large" Font-Underline="True" 
            style="z-index: 1; left: 280px; top: 47px; position: absolute" Text="Menua"></asp:Label>
    
    </div>
        <p>
            &nbsp;</p>
        <p>
            &nbsp;</p>
        <asp:HyperLink ID="HyperLinkPasahitzaAldatu" runat="server" 
        NavigateUrl="~/Erregistroa/PasahitzaAldatu.aspx" 
        style="z-index: 1; left: 286px; top: 179px; position: absolute">Pasahitza Aldatu</asp:HyperLink>
    </form>
</body>
</html>
