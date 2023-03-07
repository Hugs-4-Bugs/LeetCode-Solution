class FooBar {
    private int n;
    boolean l = true;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!l)
            {
                wait();
            }
        	printFoo.run();
            l = false;
            notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        	while(l)
            {
                wait();
            }
        	printBar.run();
            l = true;
            notify();
        }
    }
}
