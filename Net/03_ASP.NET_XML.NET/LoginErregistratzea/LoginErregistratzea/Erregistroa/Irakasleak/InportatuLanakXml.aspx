<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="InportatuLanakXml.aspx.vb" Inherits="LoginErregistratzea.InportatuLanakXml" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 423px">
    <form id="form1" runat="server">
    <div>
    
    <asp:Panel ID="Panel1" runat="server" BackColor="#FFFF99" 
        
        style="z-index: 1; left: 10px; top: 34px; position: absolute; height: 116px; width: 843px">
        <asp:Label ID="Label3" runat="server" 
        style="z-index: 1; left: 390px; top: 28px; position: absolute; height: 17px;" 
    Text="IRAKASLEA"></asp:Label>
        <asp:Label ID="Label4" runat="server" 
            style="z-index: 1; left: 325px; top: 67px; position: absolute" 
            Text="LAN GENERIKOAK INPORTATU"></asp:Label>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <asp:AccessDataSource ID="AccessDataSource1" runat="server" 
            DataFile="~/Datu_Basea/SGTA_DB.mdb" SelectCommand="SELECT KlasekoTaldeak.irakasgaiKodea FROM (KlasekoTaldeak INNER JOIN
IrakasleakTaldeak ON KlasekoTaldeak.kodea = IrakasleakTaldeak.taldeKodea) WHERE
(IrakasleakTaldeak.email = ?)">
            <SelectParameters>
                <asp:SessionParameter Name="?" SessionField="email" />
            </SelectParameters>
        </asp:AccessDataSource>
    </asp:Panel>
        <br />
    
    </div>
    <asp:Label ID="Label5" runat="server" 
        style="z-index: 1; left: 97px; top: 229px; position: absolute" 
        Text="Hautatu Irakasgaia :"></asp:Label>
    <asp:DropDownList ID="DropDownList1" runat="server" AutoPostBack="True" 
        DataSourceID="AccessDataSource1" DataTextField="irakasgaiKodea" 
        DataValueField="irakasgaiKodea" 
        style="z-index: 1; left: 226px; top: 228px; position: absolute">
    </asp:DropDownList>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        <asp:Label ID="Label6" runat="server" 
            style="z-index: 1; left: 436px; top: 266px; position: absolute; width: 262px" 
            Text="Hautatutako irakasgaiko lan generikoak :"></asp:Label>
    </p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <asp:Xml ID="XmlKontrola" runat="server"></asp:Xml>
    <asp:Button ID="Button1" runat="server" 
        style="z-index: 1; left: 90px; top: 401px; position: absolute; right: 546px;" 
        Text="Importatu XML" />
    <asp:HyperLink ID="HyperLink1" runat="server" 
        NavigateUrl="~/Erregistroa/Irakasleak/Irakasleak.aspx" 
        style="z-index: 1; left: 91px; top: 465px; position: absolute">Irakasleen Menu Nagusia</asp:HyperLink>
    </form>
</body>
</html>
