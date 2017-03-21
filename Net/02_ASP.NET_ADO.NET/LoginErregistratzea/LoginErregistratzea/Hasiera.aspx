<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Hasiera.aspx.vb" Inherits="LoginErregistratzea.Hasiera" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Label ID="Label1" runat="server" Font-Size="XX-Large" Font-Underline="True" 
            style="z-index: 1; left: 400px; top: 54px; position: absolute; width: 527px;" 
            Text="HASIERA - CARLOS ETA TELMO"></asp:Label>
    
    </div>
    <p>
        &nbsp;</p>
    <p>
        <img alt="" src="/irudiak/giltza.jpg" 
            
            style="z-index: 1; left: 604px; top: 130px; position: absolute; height: 173px; width: 206px;" /></p>
    <p>
        <asp:HyperLink ID="HyperLinkLogin" runat="server" NavigateUrl="~/Erregistroa/Login.aspx" 
            style="z-index: 1; left: 426px; top: 173px; position: absolute">Login Egin</asp:HyperLink>
    </p>
    <asp:HyperLink ID="HyperLinkErregistroa" runat="server" 
        NavigateUrl="~/Erregistroa/Erregistratzea.aspx" 
        style="z-index: 1; left: 408px; top: 234px; position: absolute">Erregistratu zaitez</asp:HyperLink>
    </form>
    </body>
</html>
