#include<iostream>
#include<vector>
using namespace std;
/* Head ends here */
void nextMove(int posx, int posy, vector <string> board) {
    //add logic here
    string s = board.at(posy);
    if (s.at(posx)=='d')
    {
        cout << "CLEAN";
        return;
    }
    int idx = s.find('d');
    if (idx != std::string::npos)
    {
        if (idx<posx)
            cout << "LEFT";
        else 
            cout << "RIGHT";
        return;
    }
    for (int i=posy+1; i<5; i++)
    {
        s = board.at(i);
        idx = s.find('d');
        if (idx !=  std::string::npos)
        {
            cout << "DOWN";
            return;
        }
    }
    for (int i=0; i<posy; i++)
    {
        s = board.at(i);
        idx = s.find('d');
        if (idx !=  std::string::npos)
        {
            cout << "UP";
            return;
        }
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
    nextMove(pos[0], pos[1], board);
    return 0;
}
