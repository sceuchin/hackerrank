#include<iostream>
#include<vector>
using namespace std;
/* Head ends here */
void next_move(int posx, int posy, int dimx, int dimy, vector <string> board) {
    //add logic here
    string s = board.at(posy);
    if (s.at(posx) == 'd')
    {
        cout << "CLEAN";
        return;
    }
    int idx, x, y, mdist = dimx+dimy-2;
    for (int i=0; i<dimx; i++)
    {
        s = board.at(i);
        idx = s.find_last_of('d',posx);
        if (idx != std::string::npos)
            if (posx-idx + abs(i-posy) < mdist)
            {    x = idx; y = i; mdist = posx-idx + abs(i-posy);}
        idx = s.find_first_of('d',posx);
        if (idx != std::string::npos)
            if (idx-posx + abs(i-posy) < mdist)
            {    x = idx; y = i; mdist = idx-posx + abs(i-posy);}
    }
    if (x < posx)
        cout << "LEFT";
    else if (x > posx)
        cout << "RIGHT";
    else if (y < posy)
        cout << "UP";
    else
        cout << "DOWN";
}
/* Tail starts here */
int main(void) {
    int pos[2];
    int dim[2];
    vector <string> board;
    cin>>pos[0]>>pos[1];
    cin>>dim[0]>>dim[1];
    for(int i=0;i<dim[0];i++) {
        string s;cin >> s;
        board.push_back(s);
    }
    next_move(pos[0], pos[1], dim[0], dim[1], board);
    return 0;
}
