//package com.company.memberapp.service;
//
//import com.company.memberapp.entity.Member;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class MemberServiceImplTest {
//    private MemberServiceImpl service;
//
//
//    @Before
//    public void setUp() throws Exception{
//        service = new MemberServiceImpl(memberRepository);
//    }
//
//    @Test
//    public void testCreate(){
//
//        Member member = new Member("2", "Digya", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta");
//        service.create(member);
//
//        member = new Member("1", "Mandala", "mandala@gmail.com",
//                "qwerqwer", "Male", "Jakarta");;
//        service.create(member);
//
//        Assert.assertTrue("Data must be two", service.findAll().size() == 2);
//
//        Member temp = service.findById("1");
//        Assert.assertTrue("Id must be 1", temp == member);
//
//    }
//
//    @Test
//    public void testFindById(){
//
//        Member member = service.findById("popo");
//        Assert.assertTrue("Data should be kosong", member == null);
//
//        service.create( new Member("2", "Digya", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta") );
//
//        member = service.findById("2");
//        Assert.assertTrue("Data should be found", member != null);
//    }
//
//    @Test
//    public void testUpdate() {
//        Member mb = new Member("2", "Digya", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta");;
//        service.create(mb);
//
//        Member up = new Member("2", "Wilson", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta");;
//        mb = service.update(up);
//
//        Assert.assertTrue("Name must be Wilson", mb.getName().equals("Wilson"));
//
//        mb = service.update(new Member("100", "Digya", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta"));
//        Assert.assertTrue("Should be none", mb == null);
//    }
//
//    @Test
//    public void testDelete(){
//
//        service.create(new Member("2", "Digya", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta"));
//        service.create(new Member("3", "Digya", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta"));
//        service.create(new Member("4", "Digya", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta"));
//        service.create(new Member("5", "Digya", "dmp@gmail.com",
//                "qwerqwer", "Male", "Jakarta"));
//
//
//        Member del = service.delete("4");
//        Assert.assertTrue("len shoudl be three", service.findAll().size() == 3);
//
//        Member delnul = service.delete("10");
//        Assert.assertTrue("should be not found", delnul == null);
//
//    }
//
//}
