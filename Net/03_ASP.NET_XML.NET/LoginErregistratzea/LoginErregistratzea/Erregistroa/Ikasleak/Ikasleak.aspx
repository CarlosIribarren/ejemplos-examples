<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Ikasleak.aspx.vb" Inherits="LoginErregistratzea.WebForm2" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
    <p>
    <asp:Panel ID="Panel4" runat="server" BackColor="#FFFFCC" BorderStyle="Double" 
        
        
        
        style="z-index: 1; left: 10px; top: 39px; position: absolute; height: 327px; width: 248px">
        <asp:HyperLink ID="HyperLink1" runat="server" 
        NavigateUrl="IkasleLanGenerikoak.aspx" 
        style="z-index: 1; left: 73px; top: 59px; position: absolute">Lan generikoak</asp:HyperLink>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Lan pertsonalak<br />
        <br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Taldeak</asp:Panel>
    <asp:Label ID="Label1" runat="server" Font-Size="XX-Large" 
        style="z-index: 1; left: 506px; top: 93px; position: absolute" 
        Text="Lanen Kudeaketa"></asp:Label>
    <asp:Label ID="Label2" runat="server" Font-Size="X-Large" 
        style="z-index: 1; left: 562px; top: 155px; position: absolute" 
        Text="Ikasleak"></asp:Label>
    &nbsp;<asp:Panel ID="Panel3" runat="server" BorderStyle="Double" 
        style="z-index: 1; left: 273px; top: 34px; position: absolute; height: 338px; width: 580px">
    </asp:Panel>
    </p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
    <asp:LinkButton ID="LinkButtonBukatuSaioa" runat="server" PostBackUrl="~/Hasiera.aspx" 
        style="z-index: 1; left: 303px; top: 346px; position: absolute">Bukatu Saioa</asp:LinkButton>
    </p>
    </form>
</body>
</html>
