<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Erregistratzea.aspx.vb" Inherits="LoginErregistratzea.Erregistratzea" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        #form1
        {
            height: 636px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Label ID="Label1" runat="server" Font-Size="XX-Large" Font-Underline="True" style="z-index: 1; left: 315px; top: 34px; position: absolute; width: 320px" Text="Erregistratzea"></asp:Label>
    
    </div>
        <asp:Label ID="LabelEmail" runat="server" 
        style="z-index: 1; left: 158px; top: 122px; position: absolute; bottom: 302px; width: 75px; right: 683px" 
        Text="Email-a : "></asp:Label>
        <asp:TextBox ID="TextBoxEmail" runat="server" 
        
        style="z-index: 1; left: 252px; top: 119px; position: absolute; bottom: 346px;" 
        TabIndex="1"></asp:TextBox>
        <asp:Label ID="LabelIzena" runat="server" 
        style="z-index: 1; left: 165px; top: 165px; position: absolute; bottom: 277px;" 
        Text="Izena :"></asp:Label>
        <asp:TextBox ID="TextBoxIzena" runat="server" 
        style="z-index: 1; left: 250px; top: 161px; position: absolute" 
        TabIndex="2"></asp:TextBox>
        <p>
            &nbsp;</p>
        <p>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                ErrorMessage="*" ForeColor="#CC0000" 
                
                style="z-index: 1; left: 235px; top: 120px; position: absolute; width: 8px;" 
                ControlToValidate="TextBoxEmail"></asp:RequiredFieldValidator>
    </p>
        <p>
            &nbsp;</p>
        <asp:Label ID="LabelAbizena" runat="server" 
        style="z-index: 1; left: 154px; top: 213px; position: absolute; bottom: 228px;" 
        Text="Abizena :"></asp:Label>
        <asp:TextBox ID="TextBoxAbizena" runat="server" 
        style="z-index: 1; left: 253px; top: 206px; position: absolute" 
        TabIndex="3"></asp:TextBox>
        <asp:Label ID="LabelPasahitza1" runat="server" 
        style="z-index: 1; left: 149px; top: 259px; position: absolute" 
        Text="Pasahitza :"></asp:Label>
        <asp:TextBox ID="TextBoxPasahitza" runat="server" 
        style="z-index: 1; left: 253px; top: 257px; position: absolute" 
        TabIndex="4"></asp:TextBox>
        <asp:Label ID="LabelGaldera" runat="server" 
        style="z-index: 1; left: 106px; top: 336px; position: absolute; width: 112px;" 
        Text="Galdera ezkutua :"></asp:Label>
        <asp:TextBox ID="TextBoxGalderaEzkutua" runat="server" 
        style="z-index: 1; left: 253px; top: 334px; position: absolute" 
        TabIndex="6"></asp:TextBox>
        <asp:Label ID="LabelErantzuna" runat="server" 
        style="z-index: 1; left: 34px; top: 380px; position: absolute; width: 190px;" 
        Text="Galdera ezkutuaren erantzuna :"></asp:Label>
        <asp:TextBox ID="TextBoxGalderarenErantzuna" runat="server" 
        style="z-index: 1; left: 250px; top: 379px; position: absolute" 
        TabIndex="7"></asp:TextBox>
        <asp:Button ID="ButtonErregistratu" runat="server" 
        style="z-index: 1; left: 397px; top: 397px; position: absolute; " 
        Text="Erregistratu" />
    <p>
        <asp:HyperLink ID="HyperLinkEgiaztatu" runat="server" 
            style="z-index: 1; left: 547px; top: 402px; position: absolute" 
            Visible="False">Egiaztatu</asp:HyperLink>
        <asp:Label ID="LabelPasahitza2" runat="server" 
            style="z-index: 1; left: 80px; top: 296px; position: absolute" 
            Text="Pasahitza Errepikatu :"></asp:Label>
        <asp:TextBox ID="TextBoxPasahitzaErrepikatua" runat="server" 
            style="z-index: 1; left: 252px; top: 296px; position: absolute" 
            TabIndex="5"></asp:TextBox>
    </p>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
        ErrorMessage="*" ForeColor="#CC0000" 
        
        style="z-index: 1; left: 233px; top: 163px; position: absolute; bottom: 225px;" 
        ControlToValidate="TextBoxIzena"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
        ErrorMessage="*" ForeColor="#CC0000" 
        style="z-index: 1; left: 233px; top: 206px; position: absolute" 
        ControlToValidate="TextBoxAbizena"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
        ErrorMessage="*" ForeColor="#CC0000" 
        
        style="z-index: 1; left: 231px; top: 261px; position: absolute; bottom: 181px; width: 8px;" 
        ControlToValidate="TextBoxPasahitza"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" 
        ErrorMessage="*" ForeColor="#CC0000" 
        
        style="z-index: 1; left: 232px; top: 339px; position: absolute; bottom: 129px; width: 8px;" 
        ControlToValidate="TextBoxGalderaEzkutua"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" 
        ErrorMessage="*" ForeColor="#CC0000" 
        
        style="z-index: 1; left: 231px; top: 387px; position: absolute; width: 8px;" 
        ControlToValidate="TextBoxGalderarenErantzuna" /></asp:RequiredFieldValidator>
    <asp:RegularExpressionValidator ID="RegularExpressionValidatorEmail" runat="server" 
        ControlToValidate="TextBoxEmail" ErrorMessage="Hau ez da email helbidea bat" 
        ForeColor="#CC0000" 
        style="z-index: 1; left: 440px; top: 120px; position: absolute" 
        ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
    <asp:CompareValidator ID="CompareValidatorPasahitzak" runat="server" 
        ControlToCompare="TextBoxPasahitza" 
        ControlToValidate="TextBoxPasahitzaErrepikatua" 
        ErrorMessage="Pasahitzak ez dira berdinak" ForeColor="#CC0000" 
        style="z-index: 1; left: 445px; top: 258px; position: absolute"></asp:CompareValidator>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" 
        ControlToValidate="TextBoxPasahitzaErrepikatua" ErrorMessage="*" 
        ForeColor="#CC0000" 
        style="z-index: 1; left: 231px; top: 297px; position: absolute; width: 8px"></asp:RequiredFieldValidator>
    <asp:Label ID="Label2" runat="server" 
        style="z-index: 1; left: 99px; top: 424px; position: absolute" 
        Text="Erabiltzaile Mota : "></asp:Label>
    <asp:TextBox ID="TextBoxErabiltzaileMota" runat="server" 
        style="z-index: 1; left: 251px; top: 425px; position: absolute"></asp:TextBox>
    <asp:Label ID="Label3" runat="server" 
        style="z-index: 1; left: 114px; top: 462px; position: absolute" 
        Text="NAN zenbakia"></asp:Label>
    <asp:Label ID="Label4" runat="server" 
        style="z-index: 1; left: 110px; top: 509px; position: absolute" 
        Text="Lan Talde Kodea"></asp:Label>
    <asp:Label ID="Label5" runat="server" 
        style="z-index: 1; left: 103px; top: 552px; position: absolute" 
        Text="Azpi Talde Kodea"></asp:Label>
    <asp:TextBox ID="TextBoxNAN" runat="server" 
        style="z-index: 1; left: 248px; top: 461px; position: absolute"></asp:TextBox>
    <asp:TextBox ID="TextBoxNAN0" runat="server" 
        style="z-index: 1; left: 248px; top: 461px; position: absolute"></asp:TextBox>
    <asp:TextBox ID="TextBoxLanTaldeKod" runat="server" 
        style="z-index: 1; left: 244px; top: 508px; position: absolute"></asp:TextBox>
    <asp:TextBox ID="TextBoxAzpiTaldKod" runat="server" 
        style="z-index: 1; left: 245px; top: 546px; position: absolute"></asp:TextBox>
    </form>
</body>
</html>
