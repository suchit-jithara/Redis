# Redis

### Create Redis Cluster

```text
docker exec -it redis-7000 redis-cli --cluster create \
redis-7000:7000 \
redis-7001:7001 \
redis-7002:7002 \
redis-7003:7003 \
redis-7004:7004 \
redis-7005:7005 \
--cluster-replicas 1
```

### ✅ 1. Check Cluster Info

```text
docker exec -it redis-7000 redis-cli -p 7000 cluster info
```

### ✅ 2. Check Cluster Nodes

```text
docker exec -it redis-7000 redis-cli -p 7000 cluster nodes
```

### ✅ 3. Test sharding

```text
docker exec -it redis-7000 redis-cli -c -p 7000 set name "Suchit"
```

```text
docker exec -it redis-7001 redis-cli -c -p 7001 get name
```
