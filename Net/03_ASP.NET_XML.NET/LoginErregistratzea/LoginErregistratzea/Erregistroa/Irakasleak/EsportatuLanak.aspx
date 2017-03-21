<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="EsportatuLanak.aspx.vb" Inherits="LoginErregistratzea.EsportatuLanak" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    <asp:Panel ID="Panel1" runat="server" BackColor="#FFFF99" 
        
        style="z-index: 1; left: 10px; top: 34px; position: absolute; height: 116px; width: 843px">
        <asp:Label ID="Label4" runat="server" 
        style="z-index: 1; left: 290px; top: 74px; position: absolute" 
        Text="LAN GENERIKOAK ESPORTATU"></asp:Label>
    </asp:Panel>
    <asp:Label ID="Label3" runat="server" 
        style="z-index: 1; left: 367px; top: 76px; position: absolute" Text="IRAKASLEA"></asp:Label>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <asp:AccessDataSource ID="AccessDataSource1" runat="server" 
            DataFile="~/Datu_Basea/SGTA_DB.mdb" 
            SelectCommand="SELECT DISTINCT kodea FROM Irakasgaiak WHERE (kodea IN (SELECT
DISTINCT irakasgaiKodea FROM KlasekoTaldeak WHERE (kodea IN (SELECT DISTINCT taldeKodea FROM IrakasleakTaldeak WHERE (email =?)))))">
            <SelectParameters>
                <asp:SessionParameter Name="?" SessionField="email" />
            </SelectParameters>
        </asp:AccessDataSource>
    
    </div>
    <p>
    <asp:Label ID="Label2" runat="server" 
        style="z-index: 1; left: 117px; top: 285px; position: absolute" 
        Text="Hautatu esportatu beharreko Irakasgaia : "></asp:Label>
    </p>
    <asp:DropDownList ID="DropDownList1" runat="server" AutoPostBack="True" 
        DataSourceID="AccessDataSource1" DataTextField="kodea" DataValueField="kodea" 
        style="z-index: 1; left: 380px; top: 283px; position: absolute">
    </asp:DropDownList>
    <asp:Button ID="Esportatu" runat="server" 
        style="z-index: 1; left: 128px; top: 386px; position: absolute" 
        Text="Esportatu" />
    <asp:GridView ID="GridView1" runat="server" 
        style="z-index: 1; left: 546px; top: 352px; position: absolute; height: 133px; width: 187px">
    </asp:GridView>
    <p>
    <asp:HyperLink ID="HyperLink1" runat="server" 
        NavigateUrl="~/Erregistroa/Irakasleak/Irakasleak.aspx" 
        style="z-index: 1; left: 91px; top: 465px; position: absolute">Irakasleen Menu Nagusia</asp:HyperLink>
    </p>
    </form>
</body>
</html>
