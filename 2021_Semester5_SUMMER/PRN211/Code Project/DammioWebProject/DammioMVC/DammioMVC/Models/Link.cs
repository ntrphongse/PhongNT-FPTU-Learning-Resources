﻿//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace DammioMVC.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    
    public partial class Link
    {
        [Display(Name ="ID")]
        public int LinkID { get; set; }

        [Required]
        [Display(Name = "Tên liên kết")]
        public string LinkName { get; set; }
        public string LinkURL { get; set; }
        [Display(Name = "Mô tả liên kết")]
        public string LinkDescription { get; set; }
        public Nullable<int> CategoryID { get; set; }
    
        public virtual Category Category { get; set; }
    }
}