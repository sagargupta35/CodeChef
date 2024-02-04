class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        while (head1 != null && head1.data == 0) head1 = head1.next;
        while (head2 != null && head2.data == 0) head2 = head2.next;
        int n = 0, m = 0;
        Node temp = head1;
        while (temp != null){
            n++;
            temp = temp.next;
        }
        temp = head2;
        while (temp != null){
            m++;
            temp = temp.next;
        }
        if(n == m){
            boolean flag = true; // true -> head1 is greater
            temp = head1;
            Node temp2 = head2;
            int s = 0;
            while (s < n){
                if(temp.data > temp2.data){
                    break;
                } else if(temp2.data > temp.data){
                    flag =false;
                    break;
                }
                temp = temp.next;
                temp2 = temp2.next;
                s++;
            }
            if(s == n) return new Node(0);
            if(!flag){
                temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }
        if(n < m){
            temp = head1;
            head1 = head2;
            head2 = temp;
        }
        head1 = reverseLinkedList(head1);
        head2 = reverseLinkedList(head2);
        boolean borrow = false;
        Node res = null;
        while (head2 != null && head1 != null){
            int f = head1.data;
            int s = head2.data;
            int d;
            if(f > s){
                if(borrow){
                    d = f-s-1;
                    borrow = false;
                } else {
                    d = f-s;
                }
            } else if(f == s && !borrow){
                d = 0;
            } else{
                if(borrow){
                    d = 9 + f - s;
                }else{
                    d = 10+f-s;
                    borrow = true;
                }
            }
            head1 = head1.next;
            head2 = head2.next;
            if(head1 != null || d != 0) {
                Node cur = new Node(d);
                cur.next = res;
                res = cur;
            }
        }
        while (head1 != null){
            int d = head1.data;
            if(borrow){
                if(d == 0){
                    d = 9;
                }else {
                    d -= 1;
                    borrow = false;
                }
            }
            head1 = head1.next;
            if(head1 != null || d != 0) {
                temp = new Node(d);
                temp.next = res;
                res = temp;
            }
        }
        while (res.data == 0) res = res.next;
        return res;
    }
    
    static Node reverseLinkedList(Node node){
         if(node == null) return null;
        Node prev = null;
        Node current = node;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
