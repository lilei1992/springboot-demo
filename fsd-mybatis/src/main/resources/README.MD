在springboot中，使用事务回滚时，添加@Transactional注解。

1：手动抛出一个异常： throw new RuntimeException();

2: 通过方法回滚：TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
