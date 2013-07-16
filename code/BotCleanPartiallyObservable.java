#include<iostream>
#include<vector>
using namespace std;
/* Head ends here */
void next_move(int posx, int posy, vector <string> board) {
    //add logic here
    string s = board.at(posy);
    if(s.at(posx)=='d')
    {
        cout << "CLEAN";
        return;
    }
    if (posy&1)
    {
        if(posx==0 || (posx==1 && s.at(posx-1)=='-'))
            cout << "DOWN";
        else if (posx==3 && s.at(posx+1)=='d')
            cout << "RIGHT";
        else 
            cout << "LEFT";            
    }
    else 
    {
        if(posx==4 || (posx==3 && s.at(posx+1)=='-'))
            cout << "DOWN";
        else if (posx==1 && s.at(posx-1)=='d')
            cout << "LEFT";
        else 
            cout << "RIGHT";            
    }
}
/* Tail starts here */
int main(void) {
    int pos[2];
    vector <string> board;
    cin>>pos[0]>>pos[1];
    for(int i=0;i<5;i++) {
        string s;cin >> s;
        board.push_back(s);
    }
    next_move(pos[0], pos[1], board);
    return 0;
}
