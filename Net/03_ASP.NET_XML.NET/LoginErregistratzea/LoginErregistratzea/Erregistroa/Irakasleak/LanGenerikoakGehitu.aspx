<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="LanGenerikoakGehitu.aspx.vb" Inherits="LoginErregistratzea.LanGenerikoakGehitu" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 306px">
    <form id="form1" runat="server">
    <div>
    
        <asp:Button ID="ButtonGehituLana" runat="server" 
            style="z-index: 1; left: 468px; top: 531px; position: absolute" 
            Text="Gehitu Lana" />
    
    <asp:Panel ID="Panel2" runat="server" BackColor="#FFFF99" 
        
            
            style="z-index: 1; left: 10px; top: 34px; position: absolute; height: 116px; width: 843px">
        <asp:Label ID="Label4" runat="server" 
        style="z-index: 1; left: 287px; top: 79px; position: absolute" 
        Text="LAN GENERIKOEN KUDEAKETA"></asp:Label>
        <asp:Label ID="Label5" runat="server" 
            style="z-index: 1; left: 302px; top: 244px; position: absolute" Text="Kodea :"></asp:Label>
    </asp:Panel>
    <asp:Label ID="Label3" runat="server" 
        style="z-index: 1; left: 367px; top: 76px; position: absolute" Text="IRAKASLEA"></asp:Label>
    
    </div>
    <asp:Panel ID="Panel1" runat="server" 
        style="z-index: 1; left: 10px; top: 34px; position: absolute; height: 19px; width: 843px">
    </asp:Panel>
    <asp:Label ID="Label6" runat="server" 
        style="z-index: 1; left: 274px; top: 332px; position: absolute" 
        Text="Deskribapena :"></asp:Label>
    <asp:Label ID="Label7" runat="server" 
        style="z-index: 1; left: 297px; top: 389px; position: absolute" 
        Text="Irakasgaia :"></asp:Label>
    <asp:Label ID="Label8" runat="server" 
        style="z-index: 1; left: 222px; top: 433px; position: absolute; right: 392px" 
        Text="Aurreikusitako Orduak :"></asp:Label>
    <asp:Label ID="Label9" runat="server" 
        style="z-index: 1; left: 303px; top: 484px; position: absolute" 
        Text="Lan Mota :"></asp:Label>
    <asp:TextBox ID="TextBoxKodea" runat="server" 
        style="z-index: 1; left: 383px; top: 276px; position: absolute"></asp:TextBox>
    <asp:TextBox ID="TextBoxDeskribapena" runat="server" 
        style="z-index: 1; left: 387px; top: 333px; position: absolute"></asp:TextBox>
    <asp:DropDownList ID="DropDownListIrakasgaia" runat="server" 
        style="z-index: 1; left: 387px; top: 385px; position: absolute" 
        DataSourceID="AccessDataSource1" DataTextField="kodea" DataValueField="kodea">
    </asp:DropDownList>
    <asp:AccessDataSource ID="AccessDataSource1" runat="server" 
        DataFile="~/Datu_Basea/SGTA_DB.mdb" 
        SelectCommand="SELECT [kodea] FROM [Irakasgaiak]"></asp:AccessDataSource>
    <asp:TextBox ID="TextBoxOrduak" runat="server" 
        style="z-index: 1; left: 391px; top: 433px; position: absolute"></asp:TextBox>
    <asp:DropDownList ID="DropDownListMota" runat="server" 
        style="z-index: 1; left: 394px; top: 480px; position: absolute">
    </asp:DropDownList>
    <asp:HyperLink ID="HyperLink1" runat="server" 
        NavigateUrl="~/Erregistroa/Irakasleak/irakasleLanak.aspx" 
        
        style="z-index: 1; left: 670px; top: 521px; position: absolute; width: 93px">Ikusi Lanak</asp:HyperLink>
    <p>
    <asp:LinkButton ID="LinkButtonBukatuSaioa" runat="server" PostBackUrl="~/Hasiera.aspx" 
        style="z-index: 1; left: 92px; top: 517px; position: absolute">Bukatu Saioa</asp:LinkButton>
    </p>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
        ErrorMessage="*" ForeColor="Red" 
        
        style="z-index: 1; left: 368px; top: 278px; position: absolute; width: 7px" 
        ControlToValidate="TextBoxKodea"></asp:RequiredFieldValidator>
    </form>
</body>
</html>
