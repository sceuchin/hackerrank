#include <iostream>
#include <vector>
using namespace std;
/* Head ends here */
string nodeToStr (int x, int y)
{
    string node = to_string(x);
    node += ' ';
    node += to_string(y);
    return node;
}
bool eqPrev (int n, int x, int y, vector <int> nx, vector <int> ny)
{
    for (int i=n-1; i>=0; i--)
        if(x==nx.at(i) && y==ny.at(i))
            return true;
    return false;
}
bool eqPrevStack (int n, int x, int y, vector <string> stack)
{
    int idx, posx, posy;
    string node;
    for (int i=stack.size()-1; i>=0; i--)
    {
        node = stack.at(i);
        idx = node.find(' ');
        posx = stoi(node.substr(0,idx));
        posy = stoi(node.substr(idx,string::npos));
        if(x==posx && y==posy)
            return true;
    }
    return false;
}
void dfs( int x, int y, int pacman_x, int pacman_y, int food_x, int food_y, vector <string> grid){
    //your logic here
    int i,j, idx, posx = pacman_x, posy = pacman_y, e, d;
    string s, node;
    vector <string> stack;
    vector <int> nx, ny;
    
    nx.push_back(posx);
    ny.push_back(posy);
    
    for (i=1; posx != food_x || posy != food_y; i++)
    {
        //UP
        if (posx > 0) 
        {
            s = grid.at(posx-1);
            if (s.at(posy)!='%' && !eqPrev(i,posx-1,posy,nx,ny))
            {
                stack.push_back( nodeToStr(posx-1,posy) );
            }
        }
        
        s = grid.at(posx);
        //LEFT
        if (posy > 0 && s.at(posy-1)!='%' 
            && !eqPrev(i,posx,posy-1,nx,ny)) 
        {
            stack.push_back( nodeToStr(posx,posy-1) );
        }
        //RIGHT
        if (posy < y && s.at(posy+1)!='%'
            && !eqPrev(i,posx,posy+1,nx,ny)) 
        {
            stack.push_back( nodeToStr(posx,posy+1) );
        }
        
        //DOWN
        if (posx < x) 
        {
            s = grid.at(posx+1);
            if (s.at(posy)!='%' && !eqPrev(i,posx+1,posy,nx,ny))
            {
                stack.push_back( nodeToStr(posx+1,posy) );
            }
        }
        
        do {
            node = stack.back();
            stack.pop_back();
            idx = node.find(' ');
            posx = stoi(node.substr(0,idx));
            posy = stoi(node.substr(idx,string::npos));
        } while (eqPrev(i,posx,posy,nx,ny) || eqPrevStack(i,posx,posy,stack));
        nx.push_back(posx);
        ny.push_back(posy);
    } 
    e = i;
    cout << e << endl;
    for (i=0; i<e; i++)
        cout << nx.at(i) <<' ' << ny.at(i) << endl;
    d = e-1;
    for (i=0; i<e; i++)
    {
        for (j=0; j<i && abs(nx.at(i)-nx.at(j))+abs(ny.at(i)-ny.at(j))>1; j++) ;
        nx.erase(nx.begin()+j+1,nx.begin()+i);
        ny.erase(ny.begin()+j+1,ny.begin()+i);
        d -= i-1-j;
        e -= i-1-j;
        i -= i-1-j;
    }
    cout << d << endl;
    for (i=0; i<=d; i++)
    {
        cout << nx.at(i) <<' ' << ny.at(i) << endl;
    }
}
/* Tail starts here */
int main(void) {

    int x,y, pacman_x, pacman_y, food_x, food_y;
    
    cin >> pacman_x >> pacman_y;
    cin >> food_x >> food_y;
    cin >> x >> y;
    
    vector <string> grid;

    for(int i=0; i<x; i++) {
        string s; cin >> s;
        grid.push_back(s);
    }

    dfs( x, y, pacman_x, pacman_y, food_x, food_y, grid);

    return 0;
}
