import './App.css';
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { Main } from './pages/Main'
import { Sell } from './pages/Sell'


const router = createBrowserRouter([
  {
    path: "/",
    children: [
      {
        path: "/",
        element: <Main />,
      },
      {
        path: "sell",
        element: <Sell />
      }
    ]
  }
])

function App() {
  return (
    <div className="App">
      <RouterProvider router={router} />
    </div>
  );
}

export { App };
