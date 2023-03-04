class MyHashSet {

    int buckets = 15000;
    List<Integer> arr[] ;
    
    // it stores the key at a unique index found using this function, idea taken from load factor
    private int hashingFunction(int key )
    {      
        return key % buckets;
    }

    public MyHashSet() {
        arr =  new LinkedList[15000];

    }
    
    // adding the value in the reuired list 
    public void add(int key) {
        int idx = hashingFunction(key);
        // if first element to be added then initiaize it 
        if(arr[idx] == null)
            arr[idx] =  new LinkedList<>();
        
        // get the list and add the value
        List<Integer> list = arr[idx];
        // this condition is to avoid duplicates
        if(!list.contains(key))
        {
        
            list.add(key);
        }
        
        
    }
    
    // remove the value if present 
    public void remove(int key) {
        int idx = hashingFunction(key);
        // check if the list from where the value has to be removed exists
        if(arr[idx]!=null)
        {
            List<Integer> list = arr[idx];
            for(int i =0;i<list.size();i++)
           {
                // if key exists then remove else if not present then do nothing
             if(key == list.get(i))
             {
                 list.remove(i);
             }
           } 
        }      
    }
    
    // same like remove 
    public boolean contains(int key) {
        int idx = hashingFunction(key);
        // check if the list is present and is not null 
        if(arr[idx]!=null)
        {
           List<Integer> list = arr[idx];
           for(int i =0;i<list.size();i++)
           {
             if(key == list.get(i))
             {
                 return true;
             }
           }
        }
        // nothing found then return false

        return false;
        
    }
}
