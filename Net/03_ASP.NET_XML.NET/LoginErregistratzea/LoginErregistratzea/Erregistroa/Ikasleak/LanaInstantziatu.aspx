<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="LanaInstantziatu.aspx.vb" Inherits="LoginErregistratzea.LanaInstantziatu" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
    <asp:TextBox ID="TextBoxErabiltzailea" runat="server" 
        style="z-index: 1; left: 150px; top: 115px; position: absolute" 
        Enabled="False"></asp:TextBox>
    <asp:Label ID="Label2" runat="server" 
        style="z-index: 1; left: 19px; top: 149px; position: absolute" 
        Text="Lan Generikoa : "></asp:Label>
    <asp:TextBox ID="TextBoxLanGeneriko" runat="server" 
        style="z-index: 1; left: 149px; top: 148px; position: absolute" 
        Enabled="False"></asp:TextBox>
    <asp:Label ID="Label3" runat="server" 
        style="z-index: 1; left: 17px; top: 188px; position: absolute" 
        Text="AurreIk.Orduak : "></asp:Label>
    <br />
    <br />
    <br />
    <asp:Panel ID="Panel1" runat="server" BackColor="#FFFF99" 
        style="z-index: 1; left: 11px; top: -45px; position: absolute; height: 69px; width: 843px; margin-top: 63px">
        <asp:Label ID="Label1" runat="server" 
        style="z-index: 1; left: 29px; top: 97px; position: absolute; width: 56px;" 
        Text="Erabiltzailea : "></asp:Label>
        <asp:Label ID="Label5" runat="server" 
            style="z-index: 1; left: 357px; top: 12px; position: absolute" Text="IKASLEA"></asp:Label>
        <asp:Label ID="Label6" runat="server" 
            style="z-index: 1; left: 307px; top: 41px; position: absolute" 
            Text="LAN GENERIKOA INSTANTZIATU"></asp:Label>
    </asp:Panel>
    <br />
    <br />
    <br />
    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
        ControlToValidate="TextBoxBenetakoOrduak" 
        ErrorMessage="Sarturikoa ez da zenbakia" ForeColor="Red" 
        style="z-index: 1; left: 288px; top: 223px; position: absolute" 
        ValidationExpression="-?[0-9]+"></asp:RegularExpressionValidator>
    <br />
    <br />
    <br />
    <br />
    <br />
    <asp:GridView ID="SaretaIkasleLanak" runat="server" AutoGenerateColumns="False" 
        DataKeyNames="email,lanGenerikoarenKodea" DataSourceID="AccessDataSource1" 
        
        
        
        style="z-index: 1; left: 467px; top: 158px; position: absolute; height: 133px; width: 187px">
        <Columns>
            <asp:BoundField DataField="email" HeaderText="email" ReadOnly="True" 
                SortExpression="email" />
            <asp:BoundField DataField="lanGenerikoarenKodea" 
                HeaderText="lanGenerikoarenKodea" ReadOnly="True" 
                SortExpression="lanGenerikoarenKodea" />
            <asp:BoundField DataField="aurreikusitakoOrduak" 
                HeaderText="aurreikusitakoOrduak" SortExpression="aurreikusitakoOrduak" />
            <asp:BoundField DataField="benetakoOrduak" HeaderText="benetakoOrduak" 
                SortExpression="benetakoOrduak" />
        </Columns>
    </asp:GridView>
    <asp:RegularExpressionValidator ID="RegularExpressionValidator2" runat="server" 
        ControlToValidate="TextBoxAurreIkOrduak" 
        ErrorMessage="Sarturikoa ez da zenbakia" ForeColor="Red" 
        style="z-index: 1; left: 288px; top: 186px; position: absolute" 
        ValidationExpression="-?[0-9]+"></asp:RegularExpressionValidator>
    <br />
    <br />
    <br />
    <asp:AccessDataSource ID="AccessDataSource1" runat="server" 
        DataFile="~/Datu_Basea/SGTA_DB.mdb" 
        SelectCommand="SELECT * FROM [IkasleakLanak] WHERE ([email] = ?)">
        <SelectParameters>
            <asp:ControlParameter ControlID="TextBoxErabiltzailea" DefaultValue="" Name="?" 
                PropertyName="Text" />
        </SelectParameters>
    </asp:AccessDataSource>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
        ControlToValidate="TextBoxAurreIkOrduak" ErrorMessage="*" ForeColor="#CC0000" 
        style="z-index: 1; left: 132px; top: 187px; position: absolute; height: 20px; width: 13px"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator11" runat="server" 
        ControlToValidate="TextBoxBenetakoOrduak" ErrorMessage="*" ForeColor="#CC0000" 
        style="z-index: 1; left: 134px; top: 221px; position: absolute; height: 20px; width: 13px"></asp:RequiredFieldValidator>
    <br />
    <asp:Button ID="ButtonLanaSortu" runat="server" 
        style="z-index: 1; left: 569px; top: 342px; position: absolute; right: 301px;" 
        Text="LanaSortu" />
    <asp:HyperLink ID="HyperLink1" runat="server" 
        NavigateUrl="~/Erregistroa/Ikasleak/IkasleLanGenerikoak.aspx" 
        style="z-index: 1; left: 88px; top: 350px; position: absolute">Atzera</asp:HyperLink>
    <br />
    <asp:LinkButton ID="LinkButtonBukatuSaioa" runat="server" PostBackUrl="~/Hasiera.aspx" 
        style="z-index: 1; left: 359px; top: 355px; position: absolute">Bukatu Saioa</asp:LinkButton>
    <br />
    <br />
    <asp:Label ID="Label4" runat="server" 
        style="z-index: 1; left: 14px; top: 220px; position: absolute" 
        Text="Benetako Orduak : "></asp:Label>
    <asp:TextBox ID="TextBoxAurreIkOrduak" runat="server" 
        
        style="z-index: 1; left: 148px; top: 185px; position: absolute; width: 128px;"></asp:TextBox>
    <asp:TextBox ID="TextBoxBenetakoOrduak" runat="server" 
        
        style="z-index: 1; left: 151px; top: 222px; position: absolute; width: 120px;"></asp:TextBox>
    <p>
        &nbsp;</p>
    </form>
</body>
</html>
