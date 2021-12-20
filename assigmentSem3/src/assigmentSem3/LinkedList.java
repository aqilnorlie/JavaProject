package assigmentSem3;

public class LinkedList {
	

    private Node head, current, tail;    
    
    public LinkedList() {
        head = current = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }    
    
    public void addFirst(Cake element) {
        Node newNode = new Node(element);
        newNode.next = this.head;
        this.head = newNode;          
        if(this.tail == null) {
            this.tail = this.head;
        }
    }
    
    public void addLast(Cake element) {
        Node newNode = new Node(element);
        
        if(this.tail == null) {
            this.head = this.tail = newNode;
        }
        else {
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }       
    }
     
    public Cake getFirst() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            this.current = this.head;
            return this.current.element;
        }
    }
    
    public Cake getLast() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            return this.tail.element;
        }
    }
    
    public Cake getNext() {
        if (this.current == this.tail) {
            return null;
        }
        else {
            this.current = this.current.next;
            return this.current.element;
        }
    }

    public void clear() {
        this.head = this.current = this.tail = null;

    }

    public boolean contains(Cake element) {
        boolean isContain = false;
        this.current = this.head;
        
        while (this.current != null) {
            if (element.equals(this.current.element)) {
                isContain = true;
                break;
            }
        }
 
        return isContain;
    }

    public Cake removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            this.current = this.head;
            this.head = this.head.next;            
            if (this.head == null)
                this.tail = null;
            return current.element;
        }
    }
        
    public Cake removeLast() {
        if (this.isEmpty()) 
            return null;
        else if (this.head == this.tail) {
            this.current = this.head;
            this.head = this.tail = null;           
            return current.element;            
        }
        else {
            this.current = this.head;
            while (this.current.next != tail) {
                this.current = this.current.next;                
            }      
            Node temp = this.tail;
            this.tail = this.current;
            this.tail.next = null;            
            return temp.element;
        }
    }
    
    public Cake removeAfter(Cake element) {        
        if (this.isEmpty()) {
            return null;
        }
        else if (this.head == this.tail) {
            this.current = this.head;
            this.head = this.tail = null;           
            return current.element;            

        }
        else {
            Node previous = this.head;            
            while (previous.next != null) {
                if (element.equals(previous.element))
                {
                    break;
                }
                previous = previous.next;
            }            
            current = previous.next;
            previous.next = current.next;          
            return current.element;
        }
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("[");        
        if (this.isEmpty()) {
            result.append("The list is empty]");
        }
        else {
            this.current = this.head;
            while (this.current != null) {
                result.append(this.current.element);
                this.current = this.current.next;
                if (this.current != null)
                    result.append(", ");
                else
                    result.append("]");                
            }            
        }
        return result.toString();
    }

}
