#include <iostream>
#include <vector>
using namespace std;
/* Head ends here */
void nextMove(int n, int c, int r, vector <string> grid){
    //your logic here
    int i,j;
    for(i=0; i<=r; i++) {
        string s = grid.at(i);
        j = s.find('p');
        if(j!=std::string::npos)
        {
            if(j<c)
                cout << "LEFT";
            else if(j>c)
                cout << "RIGHT";
            else 
                cout << "UP";
            return;
        } 
    }
    cout << "DOWN";
}
/* Tail starts here */
int main(void) {

    int n, x, y;
    vector <string> grid;

    cin >> n;
    cin >> x;
    cin >> y;

    for(int i=0; i<n; i++) {
        string s; cin >> s;
        grid.push_back(s);
    }

    nextMove(n, x, y, grid);
    return 0;
}
