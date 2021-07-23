using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccess.Repository
{
    public interface IMemberRepository
    {
        public IEnumerable<MemberObject> GetMembersList();
        public MemberObject Login(string Email, String Password);
        public void AddMember(MemberObject member);
        public void UpdateMember(MemberObject member);
        public void DeleteMember(int MemberID);
        public IEnumerable<MemberObject> SearchMember(int id);
        public IEnumerable<MemberObject> SearchMember(string name);
        public IEnumerable<MemberObject> SearchMemberByCountry(string country, IEnumerable<MemberObject> searchList);
        public IEnumerable<MemberObject> SearchMemberByCity(string country, string city, IEnumerable<MemberObject> searchList);


    }
}
