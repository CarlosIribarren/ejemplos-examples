<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Login.aspx.vb" Inherits="LoginErregistratzea.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
        <asp:Label ID="Label1" runat="server" Font-Size="XX-Large" 
        Font-Underline="True" 
        style="z-index: 1; left: 196px; top: 57px; position: absolute; width: 510px" 
        Text="Login - Hasierako Orria"></asp:Label>
        <asp:Label ID="LabelEmail" runat="server" 
        style="z-index: 1; left: 199px; top: 169px; position: absolute; height: 24px; width: 135px" 
        Text="Erabiltzailea ( email ) :"></asp:Label>
        <asp:Label ID="LabelPasahitza" runat="server" 
        style="z-index: 1; left: 270px; top: 215px; position: absolute; width: 63px" 
        Text="Pasahitza :"></asp:Label>
        <asp:TextBox ID="TextBoxEmail" runat="server" 
        style="z-index: 1; left: 386px; top: 168px; position: absolute"></asp:TextBox>
        <asp:TextBox ID="TextBoxPasahitza" runat="server" 
        style="z-index: 1; left: 384px; top: 216px; position: absolute" 
        TextMode="Password"></asp:TextBox>
        <asp:Button ID="ButtonSartu" runat="server" 
        style="z-index: 1; left: 553px; top: 260px; position: absolute; width: 72px;" 
        Text="Sartu" />
        <asp:LinkButton ID="LinkButtonBerreskuratu" runat="server" 
        style="z-index: 1; left: 374px; top: 279px; position: absolute">Pasahitza berreskuratu</asp:LinkButton>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
            ControlToValidate="TextBoxEmail" ErrorMessage="*" ForeColor="#CC0000" 
            
            style="z-index: 1; left: 366px; top: 170px; position: absolute; width: 15px"></asp:RequiredFieldValidator>
    </p>
    <p>
        <asp:RegularExpressionValidator ID="RegularExpressionValidatorEmail" runat="server" 
            ControlToValidate="TextBoxEmail" ErrorMessage="Email helbide bat sartu mesedez" 
            ForeColor="#CC0000" 
            style="z-index: 1; left: 582px; top: 168px; position: absolute; width: 206px" 
            ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
    </p>
    <p>
        &nbsp;</p>
    <asp:HyperLink ID="HyperLinkBerria" runat="server" 
        NavigateUrl="~/Erregistroa/Erregistratzea.aspx" 
        style="z-index: 1; left: 404px; top: 252px; position: absolute">Erabiltzaile berria</asp:HyperLink>
    </form>
</body>
</html>
