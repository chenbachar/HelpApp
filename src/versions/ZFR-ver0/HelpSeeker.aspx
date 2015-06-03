<%@ Page Language="C#" AutoEventWireup="true" CodeFile="HelpSeeker.aspx.cs" Inherits="HelpSeeker" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
 
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
