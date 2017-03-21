<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="irakasleLanak.aspx.vb" Inherits="LoginErregistratzea.irakasleLanak" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
    <asp:Panel ID="Panel1" runat="server" BackColor="#FFFF99" 
        
        style="z-index: 1; left: 10px; top: 34px; position: absolute; height: 116px; width: 843px">
    </asp:Panel>
    <asp:Label ID="Label3" runat="server" 
        style="z-index: 1; left: 367px; top: 76px; position: absolute" Text="IRAKASLEA"></asp:Label>
    <asp:Label ID="Label4" runat="server" 
        style="z-index: 1; left: 286px; top: 111px; position: absolute" 
        Text="LAN GENERIKOEN KUDEAKETA"></asp:Label>
    <p>
    </p>
    <asp:Label ID="Label2" runat="server" 
        style="z-index: 1; left: 117px; top: 285px; position: absolute" 
        Text="Irakasgaia hautatu : "></asp:Label>
    <asp:DropDownList ID="DropDownListKodea" runat="server" 
        DataSourceID="AccessDataSourceIrakasleakTaldeak" DataTextField="irakasgaiKodea" 
        DataValueField="irakasgaiKodea" 
        style="z-index: 1; left: 251px; top: 283px; position: absolute" 
        AutoPostBack="True">
    </asp:DropDownList>
    <asp:Button ID="Button1" runat="server" 
        style="z-index: 1; left: 464px; top: 268px; position: absolute" 
        Text="Lan Berriak Gehitu" />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <asp:AccessDataSource ID="AccessDataSourceIrakasleakTaldeak" runat="server" 
        DataFile="~/Datu_Basea/SGTA_DB.mdb" SelectCommand="SELECT KlasekoTaldeak.irakasgaiKodea FROM (KlasekoTaldeak INNER JOIN
IrakasleakTaldeak ON KlasekoTaldeak.kodea = IrakasleakTaldeak.taldeKodea) WHERE
(IrakasleakTaldeak.email = ?)">
        <SelectParameters>
            <asp:SessionParameter Name="?" SessionField="email" />
        </SelectParameters>
    </asp:AccessDataSource>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" 
        DataKeyNames="kodea" DataSourceID="AccessDataSourceLanGenerikoak" 
        
        
        style="z-index: 1; left: 399px; top: 342px; position: absolute; height: 133px; width: 187px" 
        AllowSorting="True" AutoGenerateEditButton="True">
        <Columns>
            <asp:BoundField DataField="kodea" HeaderText="kodea" ReadOnly="True" 
                SortExpression="kodea" />
            <asp:BoundField DataField="deskribapena" HeaderText="deskribapena" 
                SortExpression="deskribapena" />
            <asp:BoundField DataField="irakasgaiKodea" HeaderText="irakasgaiKodea" 
                SortExpression="irakasgaiKodea" />
            <asp:BoundField DataField="aurreikusitakoOrduak" 
                HeaderText="aurreikusitakoOrduak" SortExpression="aurreikusitakoOrduak" />
            <asp:CheckBoxField DataField="ustiapenean" HeaderText="ustiapenean" 
                SortExpression="ustiapenean" />
            <asp:BoundField DataField="lanMota" HeaderText="lanMota" 
                SortExpression="lanMota" />
        </Columns>
    </asp:GridView>
    <br />
    <br />
    <asp:AccessDataSource ID="AccessDataSourceLanGenerikoak" runat="server" 
        DataFile="~/Datu_Basea/SGTA_DB.mdb" 
        DeleteCommand="DELETE FROM [LanGenerikoak] WHERE [kodea] = ?" 
        InsertCommand="INSERT INTO [LanGenerikoak] ([kodea], [deskribapena], [irakasgaiKodea], [aurreikusitakoOrduak], [ustiapenean], [lanMota]) VALUES (?, ?, ?, ?, ?, ?)" 
        SelectCommand="SELECT * FROM [LanGenerikoak] WHERE ([irakasgaiKodea] = ?)" 
        UpdateCommand="UPDATE [LanGenerikoak] SET [deskribapena] = ?, [irakasgaiKodea] = ?, [aurreikusitakoOrduak] = ?, [ustiapenean] = ?, [lanMota] = ? WHERE [kodea] = ?">
        <DeleteParameters>
            <asp:Parameter Name="kodea" Type="String" />
        </DeleteParameters>
        <InsertParameters>
            <asp:Parameter Name="kodea" Type="String" />
            <asp:Parameter Name="deskribapena" Type="String" />
            <asp:Parameter Name="irakasgaiKodea" Type="String" />
            <asp:Parameter Name="aurreikusitakoOrduak" Type="Int32" />
            <asp:Parameter Name="ustiapenean" Type="Boolean" />
            <asp:Parameter Name="lanMota" Type="String" />
        </InsertParameters>
        <SelectParameters>
            <asp:ControlParameter ControlID="DropDownListKodea" Name="irakasgaiKodea" 
                PropertyName="SelectedValue" Type="String" />
        </SelectParameters>
        <UpdateParameters>
            <asp:Parameter Name="deskribapena" Type="String" />
            <asp:Parameter Name="irakasgaiKodea" Type="String" />
            <asp:Parameter Name="aurreikusitakoOrduak" Type="Int32" />
            <asp:Parameter Name="ustiapenean" Type="Boolean" />
            <asp:Parameter Name="lanMota" Type="String" />
            <asp:Parameter Name="kodea" Type="String" />
        </UpdateParameters>
    </asp:AccessDataSource>
    <br />
    <br />
    <br />
    <asp:LinkButton ID="LinkButtonBukatuSaioa" runat="server" PostBackUrl="~/Hasiera.aspx" 
        style="z-index: 1; left: 93px; top: 502px; position: absolute">Bukatu Saioa</asp:LinkButton>
    <br />
    <br />
    </form>
</body>
</html>
