<%@ Page Title="" Language="C#" MasterPageFile="~/masterPage.Master" AutoEventWireup="true" CodeBehind="helpRequest.aspx.cs" Inherits="helpApp.helpRequest" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
        .auto-style3 {
            width: 100%;
        }
        .auto-style4 {
            height: 100%;
            width: 100%;
        }
        .auto-style5 {
            height: 100%;
            width: 66%;
        }
        .auto-style1 {
            text-align: right;
        }
        </style>
</asp:Content>



<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">



    <table class="auto-style3" style="background-color: #F2F2F2; border-spacing: 0px; top: -40%">
        <tr style="border-spacing: 0px">
            <td style="border-spacing: 0px; text-align: center;" class="auto-style5">

                &nbsp;</td>
            <td style="border-spacing: 0px; text-align: center;" class="auto-style4">

        <asp:Label ID="Label1" runat="server" Text="בקשת עזרה" Font-Names="david" Font-Bold="True" ForeColor="#00B0F0" Font-Size="200%" style="text-align: center"></asp:Label>
                
    <p class="auto-style1">
        תוכן הבקשה</p>
    <p class="auto-style1">
        <asp:TextBox ID="TextBox1" runat="server" TextMode="MultiLine"></asp:TextBox>
    </p>
    <p class="auto-style1">
        שם</p>
    <p class="auto-style1">
        <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
    </p>
    <p class="auto-style1">
        טלפון</p>
    <p class="auto-style1">
        <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
    </p>



            </td>
            <td style="border-spacing: 0px; text-align: center;" class="auto-style4">

                &nbsp;</td>
        </tr>
        <tr style="border-spacing: 0px">
            <td style="border-spacing: 0px; text-align: center;" class="auto-style5">

                &nbsp;</td>
            <td style="border-spacing: 0px; text-align: center;" class="auto-style4">

                &nbsp;</td>
            <td style="border-spacing: 0px; text-align: center;" class="auto-style4">

                &nbsp;</td>
        </tr>
        <tr style="border-spacing: 0px">
            <td style="border-spacing: 0px; text-align: center;" class="auto-style5">

                &nbsp;</td>
            <td style="border-spacing: 0px; text-align: center;" class="auto-style4">

                &nbsp;</td>
            <td style="border-spacing: 0px; text-align: center;" class="auto-style4">

                &nbsp;</td>
        </tr>
    </table>



</asp:Content>
