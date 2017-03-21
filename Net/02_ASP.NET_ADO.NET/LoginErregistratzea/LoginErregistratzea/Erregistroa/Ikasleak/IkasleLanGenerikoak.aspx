<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="IkasleLanGenerikoak.aspx.vb" Inherits="LoginErregistratzea.IkasleLanGenerikoak" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        #form1
        {
            height: 458px;
        }
    </style>
</head>
<body style="height: 474px">
    <form id="form1" runat="server">
    <asp:Panel ID="Panel1" runat="server" Height="70px">
    </asp:Panel>
    <div>
    
    </div>
    <asp:Panel ID="Panel2" runat="server" BackColor="#FFFF99" BorderColor="Black" 
        style="z-index: 1; left: 14px; top: 20px; position: absolute; height: 64px; width: 843px">
    </asp:Panel>
    <asp:Label ID="Label3" runat="server" 
        style="z-index: 1; left: 345px; top: 28px; position: absolute" Text="IKASLEA"></asp:Label>
    <asp:DropDownList ID="kodeLista" runat="server" 
        style="z-index: 1; left: 433px; top: 142px; position: absolute" 
        AutoPostBack="True">
    </asp:DropDownList>
    <asp:Label ID="Label2" runat="server" 
        style="z-index: 1; left: 302px; top: 144px; position: absolute" 
        Text="Hautatu irakasgaia"></asp:Label>
    <p>
        &nbsp;</p>
    <p>
        <asp:CheckBox ID="CheckBoxKodea" runat="server" 
            style="z-index: 1; left: 557px; top: 174px; position: absolute" 
            Text="Kodea" Enabled="False" Checked="True" />
    </p>
    <p>
        <asp:Label ID="Label4" runat="server" 
            style="z-index: 1; left: 267px; top: 54px; position: absolute" 
            Text="LAN GENERIKOEN KUDEAKETA"></asp:Label>
        </p>
    <p>
        <asp:CheckBox ID="CheckBoxAurreikOrd" runat="server" 
            style="z-index: 1; left: 560px; top: 242px; position: absolute" 
            Text="Aurreik. Ord" AutoPostBack="True" />
    </p>
    <p>
        <asp:Button ID="Button1" runat="server" 
            style="z-index: 1; left: 428px; top: 283px; position: absolute" 
            Text="Ikusi Lanak" />
    </p>
    <p>
        <asp:CheckBox ID="CheckBoxDeskribapena" runat="server" 
            style="z-index: 1; left: 556px; top: 208px; position: absolute" 
            Text="Deskribapena" AutoPostBack="True" />
    </p>
    <asp:CheckBox ID="CheckBoxLanMota" runat="server" 
        style="z-index: 1; left: 562px; top: 279px; position: absolute" 
        Text="Lan Mota" AutoPostBack="True" />
    <asp:GridView ID="GridView1" runat="server" 
        style="z-index: 1; left: 347px; top: 330px; position: absolute; height: 133px; width: 187px" 
        ViewStateMode="Enabled" AllowSorting="True" 
        AutoGenerateColumns="False">
        <Columns>
            <asp:CommandField ButtonType="Button" SelectText="Instantziatu" 
                ShowSelectButton="True" />
            <asp:BoundField DataField="kodea" HeaderText="kodea" SortExpression="kodea" />
            <asp:BoundField DataField="deskribapena" HeaderText="deskribapena" 
                SortExpression="deskribapena" />
            <asp:BoundField DataField="aurreikusitakoOrduak" 
                HeaderText="aurreikusitakoOrduak" SortExpression="aurreikusitakoOrduak" />
            <asp:BoundField DataField="lanMota" HeaderText="lanMota" 
                SortExpression="lanMota" />
            <asp:BoundField DataField="irakasgaiKodea" HeaderText="irakasgaiKodea" 
                SortExpression="irakasgaiKodea" />
        </Columns>
    </asp:GridView>
    <p>
    <asp:LinkButton ID="LinkButtonBukatuSaioa" runat="server" PostBackUrl="~/Hasiera.aspx" 
        style="z-index: 1; left: 93px; top: 502px; position: absolute">Bukatu Saioa</asp:LinkButton>
    </p>
    </form>
</body>
</html>
