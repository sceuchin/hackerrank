#include<iostream>
#include<vector>
using namespace std;
/* Head ends here */
void next_move(int posx, int posy, vector <string> board) {
    //add logic here
    string s = board.at(posy);
    if(s.at(posx)=='d')
        cout << "CLEAN";
    else 
    {
        if(posx != 0 || posx != 4)
        {
            int left = s.find_first_of('d',0) ;
            int right = s.find_last_of('d',4) ;
            
            if(left!=std::string::npos)
            {
                if (posx-left < 0)
                    cout << "RIGHT";
                else if (right-posx < 0)
                    cout << "LEFT";
                else if (posx-left > right-posx)
                    cout << "RIGHT";
                else
                    cout << "LEFT";
                return;
            }
        }
        cout << "DOWN";
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
