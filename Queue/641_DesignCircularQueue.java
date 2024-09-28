//LeetrCode URL - https://leetcode.com/problems/design-circular-deque/description/

//LinkedList
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int x) {
        val = x;
        next = null;
    }
}


class MyCircularDeque {
    
//Doing implementation of CircularQueue using LinkedList
    int size;
    int count;
    ListNode front;
    ListNode end;
    public MyCircularDeque(int k) {
        size = k;
        count = 0;
    }
    
    public boolean insertFront(int value) {
        if(count == size){
            return false;
        }

        if(front == null){      //means end is also null
            front = new ListNode(value);
            end = front;
            count++;
            return true;
        }

        ListNode temp = new ListNode(value);
        temp.next = front;
        front = temp;
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(count == size){
            return false;
        }

        if(end == null){
            front = new ListNode(value);
            end = front;
            count++;
            return true;
        }
        
        ListNode temp = new ListNode(value);
        end.next = temp;
        end = end.next;
        count++;

        return true;
    }
    
    public boolean deleteFront() {
        if(front == null || count == 0){
            return false;
        }
        
        ListNode temp = front;
        front = front.next;
        temp = null;
        count--;

        if(count == 0){
            front = null;
            end = null;
        }

        return true;
    }
    
    public boolean deleteLast() {
        if(end == null || count == 0){
            return false;
        }

        if(front == end){
            front = null;
            end = null;
            count--;
            return true;
        }
                  

        ListNode temp = front;
        while(temp.next != end){
            temp = temp.next;
        }

        temp.next = null;
        end = temp;
        count--;

        if(count == 0){
            front = null;
            end = null;
        }

        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return front.val;
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return end.val;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;        
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
