    package rbs;

    import java.util.ArrayList;
    //import org.apache.commons.collections.MapIterator;
    //import org.apache.commons.collections.map.LRUMap;

    /**
     * @author Crunchify.com
     */

   /* public class CacheExample<K, T> {

        private long timeToLive;
        private LRUMap cacheMap;

        protected class EntryObject {
            public long lastAccessed = System.currentTimeMillis();
            public T value;

            protected EntryObject(T value) {
                this.value = value;
            }
        }

        public CacheExample(long crunchifyTimeToLive, final long crunchifyTimerInterval, int maxItems) {
            this.timeToLive = crunchifyTimeToLive * 1000;

            cacheMap = new LRUMap(maxItems);

            if (timeToLive > 0 && crunchifyTimerInterval > 0) {

                Thread t = new Thread(new Runnable() {
                    public void run() {
                        while (true) {
                            try {
                                Thread.sleep(crunchifyTimerInterval * 1000);
                            } catch (InterruptedException ex) {
                            }
                            cleanup();
                        }
                    }
                });

                t.setDaemon(true);
                t.start();
            }
        }

        public void put(K key, T value) {
            synchronized (cacheMap) {
                cacheMap.put(key, new EntryObject(value));
            }
        }

        @SuppressWarnings("unchecked")
        public T get(K key) {
            synchronized (cacheMap) {
                EntryObject c = (EntryObject) cacheMap.get(key);

                if (c == null)
                    return null;
                else {
                    c.lastAccessed = System.currentTimeMillis();
                    return c.value;
                }
            }
        }

        public void remove(K key) {
            synchronized (cacheMap) {
                cacheMap.remove(key);
            }
        }

        public int size() {
            synchronized (cacheMap) {
                return cacheMap.size();
            }
        }

        @SuppressWarnings("unchecked")
        public void cleanup() {

            long now = System.currentTimeMillis();
            ArrayList<K> deleteKey = null;

            synchronized (cacheMap) {
                MapIterator itr = cacheMap.mapIterator();

                deleteKey = new ArrayList<K>((cacheMap.size() / 2) + 1);
                K key = null;
                EntryObject c = null;

                while (itr.hasNext()) {
                    key = (K) itr.next();
                    c = (EntryObject) itr.getValue();

                    if (c != null && (now > (timeToLive + c.lastAccessed))) {
                        deleteKey.add(key);
                    }
                }
            }

            for (K key : deleteKey) {
                synchronized (cacheMap) {
                    cacheMap.remove(key);
                }

                Thread.yield();
            }
        }
    }*/