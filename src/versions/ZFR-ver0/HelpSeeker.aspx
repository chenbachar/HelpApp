<%@ Page Language="C#" AutoEventWireup="true" CodeFile="HelpSeeker.aspx.cs" Inherits="HelpSeeker" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>

    <form id="form1" runat="server">
    <div id="main" style="border-style: solid; border-width: thick; margin-left: auto; margin-right: auto; background-color: aqua; width: 60%; margin-top: 5%; direction: rtl">
            <asp:Label ID="Label1" runat="server" Text="בקשת עזרה:" Font-Bold="True" Font-Names="Arial" Font-Size="XX-Large" Font-Underline="True"></asp:Label>
            <table style="width: 50%;">
                <tr>
                    <td style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; width: 30%;">תוכן הבקשה:</td>
                    <td>
                        <asp:TextBox ID="TextBox1" runat="server" TextMode="MultiLine"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td style="width: 30%; font-family: Arial, Helvetica, sans-serif; font-size: x-large;">שם:</td>
                    <td>
                        <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td style="width: 30%; font-family: Arial, Helvetica, sans-serif; font-size: x-large;">טלפון:</td>
                    <td>
                        <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td style="width: 20%;">
                        <asp:Button ID="Button1" runat="server" BackColor="White" BorderStyle="Solid" Text="שלח" Font-Size="Medium" Height="41px" Width="61%" />
                        <br />
                    </td>
                    <td>
                        &nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
