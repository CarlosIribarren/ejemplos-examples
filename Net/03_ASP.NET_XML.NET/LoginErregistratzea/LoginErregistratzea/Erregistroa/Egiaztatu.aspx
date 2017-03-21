<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Egiaztatu.aspx.vb" Inherits="LoginErregistratzea.Egiaztatu" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Label ID="Label1" runat="server" Font-Size="XX-Large" 
            Font-Underline="True" 
            style="z-index: 1; left: 315px; top: 34px; position: absolute; width: 320px" 
            Text="Egiaztatu"></asp:Label>
    
    </div>
    <p>
        <asp:HyperLink ID="HyperLink1" runat="server" 
            NavigateUrl="~/Erregistroa/Login.aspx" 
            
            style="z-index: 1; left: 699px; top: 149px; position: absolute; width: 87px;">Login orria</asp:HyperLink>
    </p>
    <p>
        &nbsp;</p>
        <asp:Label ID="LabelMezua" runat="server" 
            
        style="z-index: 1; left: 176px; top: 149px; position: absolute; width: 457px;" 
        Text="Label"></asp:Label>
    </form>
</body>
</html>
