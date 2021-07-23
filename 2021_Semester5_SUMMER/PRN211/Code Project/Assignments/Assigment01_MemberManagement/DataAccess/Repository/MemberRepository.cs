using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccess.Repository
{
    public class MemberRepository : IMemberRepository
    {
        public void AddMember(MemberObject member) => MemberDAO.Instance.AddMember(member);

        public void DeleteMember(int MemberID) => MemberDAO.Instance.Delete(MemberID);

        public IEnumerable<MemberObject> GetMembersList()
        {
            return MemberDAO.Instance.GetMembersList;
        }
        public IEnumerable<MemberObject> SearchMember(int id)
        {
            return MemberDAO.Instance.SearchMember(id);
        }

        public IEnumerable<MemberObject> SearchMember(string name)
        {
            return MemberDAO.Instance.SearchMember(name);
        }
        public MemberObject Login(string Email, string Password)
        {
            return MemberDAO.Instance.Login(Email, Password);
        }

        

        public void UpdateMember(MemberObject member) => MemberDAO.Instance.Update(member);

        public IEnumerable<MemberObject> SearchMemberByCountry(string country, IEnumerable<MemberObject> searchList)
        {
            return MemberDAO.Instance.FilterMemberByCountry(country, searchList);
        }

        public IEnumerable<MemberObject> SearchMemberByCity(string country, string city, IEnumerable<MemberObject> searchList)
        {
            return MemberDAO.Instance.FilterMemberByCity(country, city, searchList);
        }
    }
}
