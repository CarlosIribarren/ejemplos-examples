<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Irakasleak.aspx.vb" Inherits="LoginErregistratzea.Irakasleak" %>

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
        &nbsp;</p>
    <asp:Label ID="Label1" runat="server" Font-Size="XX-Large" 
        style="z-index: 1; left: 490px; top: 221px; position: absolute" 
        Text="Lanen Kudeaketa"></asp:Label>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <asp:Panel ID="Panel3" runat="server" BorderStyle="Double" 
        style="z-index: 1; left: 273px; top: 34px; position: absolute; height: 338px; width: 580px">
    </asp:Panel>
    <br />
    <br />
    <asp:Panel ID="Panel4" runat="server" BackColor="#FFFF99" BorderStyle="Double" 
        
        
        style="z-index: 1; left: 10px; top: 39px; position: absolute; height: 327px; width: 248px">
        <asp:HyperLink ID="HyperLink3" runat="server" 
    style="z-index: 1; left: 68px; top: 164px; position: absolute" 
            NavigateUrl="~/Erregistroa/Irakasleak/InportatuLanakXml.aspx">Inportatu Lanak (Xml)</asp:HyperLink>
        <asp:HyperLink ID="HyperLink4" runat="server" 
            NavigateUrl="~/Erregistroa/Irakasleak/EsportatuLanak.aspx" 
            style="z-index: 1; left: 70px; top: 246px; position: absolute">Esportatu Lanak</asp:HyperLink>
    </asp:Panel>
    <br />
    <asp:HyperLink ID="HyperLink1" runat="server" 
        NavigateUrl="~/Erregistroa/Irakasleak/irakasleLanak.aspx" 
        style="z-index: 1; left: 89px; top: 143px; position: absolute">Lanak</asp:HyperLink>
    <br />
    <asp:Label ID="Label2" runat="server" Font-Size="X-Large" 
        style="z-index: 1; left: 552px; top: 290px; position: absolute" 
        Text="Irakasleak"></asp:Label>
    <br />
    <br />
    <p>
        &nbsp;</p>
        <asp:LinkButton ID="LinkButtonBukatuSaioa" runat="server" PostBackUrl="~/Hasiera.aspx" 
        style="z-index: 1; left: 298px; top: 348px; position: absolute">Bukatu Saioa</asp:LinkButton>
    </form>
</body>
</html>
