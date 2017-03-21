<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="PasahitzaAldatu.aspx.vb" Inherits="LoginErregistratzea.PasahitzaAldatu" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <p>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                ControlToValidate="pasahitzBerria1" ErrorMessage="*" ForeColor="#CC0000" 
                style="z-index: 1; left: 414px; top: 200px; position: absolute"></asp:RequiredFieldValidator>
            <asp:Label ID="Label1" runat="server" Font-Bold="True" Font-Overline="False" 
                Font-Size="X-Large" 
                style="z-index: 1; left: 401px; top: 58px; position: absolute" 
                Text="Pasahitza Aldatu" Font-Underline="True"></asp:Label>
        </p>
        <p>
            &nbsp;</p>
        <p>
            &nbsp;</p>
        <p>
            &nbsp;</p>
        <asp:Label ID="LabelPasZaharra" runat="server" 
            style="z-index: 1; left: 189px; top: 159px; position: absolute; right: 302px; width: 223px;" 
            Text="Sar ezazu zure pasahitza ( zaharra ) : "></asp:Label>
        <asp:TextBox ID="pasahitza" runat="server" 
            style="z-index: 1; left: 430px; top: 159px; position: absolute; right: 340px;" 
            TabIndex="1"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
            ControlToValidate="pasahitzBerria2" ErrorMessage="*" ForeColor="#CC0000" 
            style="z-index: 1; left: 414px; top: 239px; position: absolute"></asp:RequiredFieldValidator>
        <p>
            &nbsp;</p>
        <asp:Label ID="LabelPasBerria1" runat="server" 
            style="z-index: 1; left: 232px; top: 202px; position: absolute" 
            Text="Sar ezazu pasahitz ( berria ) : "></asp:Label>
        <p>
            <asp:Label ID="LabelPasBerria2" runat="server" 
                style="z-index: 1; left: 147px; top: 241px; position: absolute; height: 19px; margin-bottom: 1px" 
                Text="Sar ezazu ( pasahitz ) berria bigarren aldiz : "></asp:Label>
            <asp:TextBox ID="pasahitzBerria1" runat="server" 
                style="z-index: 1; left: 429px; top: 198px; position: absolute" TabIndex="2"></asp:TextBox>
            <asp:Button ID="ButtonAldatu" runat="server" 
                style="z-index: 1; left: 477px; top: 274px; position: absolute; height: 26px; right: 229px;" 
                Text="Aldatu" TabIndex="4" />
        </p>
        <asp:TextBox ID="pasahitzBerria2" runat="server" 
            style="z-index: 1; left: 429px; top: 237px; position: absolute; right: 341px;" 
            TabIndex="3"></asp:TextBox>
        <asp:HyperLink ID="HyperLinkLogin" runat="server" 
            NavigateUrl="~/Erregistroa/Login.aspx" 
            style="z-index: 1; left: 607px; top: 278px; position: absolute" 
            TabIndex="5">Login Orria</asp:HyperLink>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
            ControlToValidate="pasahitza" ErrorMessage="*" ForeColor="#CC0000" 
            style="z-index: 1; left: 416px; top: 160px; position: absolute"></asp:RequiredFieldValidator>
        </p>
        <asp:CompareValidator ID="CompareValidatorPasahitzak" runat="server" 
            ControlToCompare="pasahitzBerria1" ControlToValidate="pasahitzBerria2" 
            ErrorMessage="Pasahitzak ez dira berdinak" ForeColor="#CC0000" 
            
            style="z-index: 1; left: 600px; top: 201px; position: absolute; width: 180px"></asp:CompareValidator>
    </form>
    </body>
</html>
