package Redis;

import redis.clients.jedis.Jedis;

/**
 * @author rbhavsar
 * Created on 3/24/19.
 */
public class App {

  public static void main(String[] args) {
    Jedis jedis = new Jedis("localhost");
    //check whether server is running or not
//    System.out.println("Server is running: "+jedis.ping());
//    //String
//    jedis.set("tutorial-name", "Redis tutorial");
//
//    //Store data in redis list
//    jedis.lpush("tutorial-list", "Redis");
//    jedis.lpush("tutorial-list", "Mongodb");
//    jedis.lpush("tutorial-list", "Mysql");
//    //Read string
//    System.out.println(jedis.get("tutorial-name"));
//
//    jedis.keys("*");
//
//    //Read list
//    List<String> list = jedis.lrange("tutorial-list", 0 ,5);
//
//    for(int i = 0; i<list.size(); i++) {
//      System.out.println("Stored string in redis:: "+list.get(i));
//    }
//
//    jedis.flushAll();
//    System.out.println("Connection to server sucessfully");

//    String userOneId = "4352523";
//    String userTwoId = "4849888";
//
      //Pipeline
//    Pipeline p = jedis.pipelined();
//    p.sadd("searched#" + userOneId, "paris");
//    p.zadd("ranking", 126, userOneId);
//    p.zadd("ranking", 325, userTwoId);
//    Response<Boolean> pipeExists = p.sismember("searched#" + userOneId, "paris");
//    Response<Set<String>> pipeRanking = p.zrange("ranking", 0, -1);
//    p.sync();
//
//    //String exists = pipeExists.get();
//    Set<String> ranking = pipeRanking.get();

    //Transaction

//    String friendsPrefix = "friends#";
//    String userOneId = "4352523";
//    String userTwoId = "5552321";
//
//    Transaction t = jedis.multi();
//    t.sadd(friendsPrefix + userOneId, userTwoId);
//    t.sadd(friendsPrefix + userTwoId, userOneId);
//    t.exec();

    //Hashes --> String field with value

//    jedis.hset("user#1", "name", "Peter");
//    jedis.hset("user#1", "job", "politician");
//
//    String name = jedis.hget("user#1", "name");
//
//    Map<String, String> fields = jedis.hgetAll("user#1");
//    String job = fields.get("job");

    //SET
//    jedis.sadd("nicknames", "nickname#1");
//    jedis.sadd("nicknames", "nickname#2");
//    jedis.sadd("nicknames", "nickname#1");
//
//    Set<String> nicknames = jedis.smembers("nicknames");
//    boolean exists = jedis.sismember("nicknames", "nickname#1");

    //LIST

//    jedis.lpush("queue#tasks", "firstTask");
//    jedis.lpush("queue#tasks", "secondTask");
//    String task = jedis.rpop("queue#tasks");

    //String
    jedis.set("events/city/rome", "32,15,223,828");
    String cachedResponse = jedis.get("events/city/rome");

  }

}
