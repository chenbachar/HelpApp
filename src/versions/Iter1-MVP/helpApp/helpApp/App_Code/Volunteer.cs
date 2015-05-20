using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace helpApp.App_Code
{
    public class Volunteer
    {
        private string name, language;
        private int phone;

        public Volunteer(string name, int phone, string language)
        {
            this.name = name;
            this.phone = phone;
            this.language = language;


        }



    }
}