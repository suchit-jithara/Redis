# Redis

### Create Redis Cluster

```text
docker exec -it redis-7000 redis-cli --cluster create \
172.17.0.1:7000 \
172.17.0.1:7001 \
172.17.0.1:7002 \
172.17.0.1:7003 \
172.17.0.1:7004 \
172.17.0.1:7005 \
--cluster-replicas 1 \
--cluster-yes \
-a myRedisPass123
```

### ✅ 1. Check Cluster Info

```text
docker exec -it redis-7000 redis-cli -a myRedisPass123 -p 7000 cluster info 
```

### ✅ 2. Check Cluster Nodes

```text
docker exec -it redis-7000 redis-cli -a myRedisPass123 -p 7000 cluster nodes
```

### ✅ 3. Test sharding

```text
docker exec -it redis-7000 redis-cli -a myRedisPass123 -c -p 7000 set name "Suchit"
```

```text
docker exec -it redis-7001 redis-cli -c -p 7001 get name
```

### For check all key from cluster 

```text
redis-cli -a myRedisPass123 --cluster call 172.17.0.1:7000 keys '*'
```

### Delete any Key 

```text
redis-cli -a myRedisPass123 --cluster call 172.17.0.1:7000 DEL name
```