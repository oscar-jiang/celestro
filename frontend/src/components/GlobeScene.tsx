import {Stars} from "@react-three/drei/core/Stars";
import {Canvas} from "@react-three/fiber";
import Earth from "./Earth.tsx";
import {OrbitControls} from "@react-three/drei";
import optionsIcon from "..//assets/options.svg";
import type {Satellite} from "../types/Satellite.ts";
import {useEffect, useState} from "react";
import {getSatellites} from "../api/satelliteApi.ts";
import {convertToTLE} from "../util/ConvertToTLE.ts";
import {calculateOrbitTrail} from "../util/Orbit.ts";
import OrbitTrail from "./OrbitTrail.tsx";

// https://threejs.org/docs/#examples/en/controls/OrbitControls
// https://threejs.org/docs/index.html#api/en/extras/Controls
export const GlobeScene = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const [satellites, setSatellites] = useState<Satellite[]>([]);
  const [selectedIds, setSelectedIds] = useState<number[]>([]);

  const toggleSatelliteSelection = (id: number) => {
    setSelectedIds((curr) => {
      const iterator = curr.indexOf(id);
      console.log("Toggle:", id, "Current selected:", curr);
      if (iterator !== -1) {
        const updatedSatellites = curr.filter((item) => item !== id);
        return updatedSatellites;
      } else {
        const updatedSatellites = [...curr, id];
        return updatedSatellites;
      }
    })
  };

  useEffect(() => {
    getSatellites()
      .then(setSatellites)
      .catch(console.error);
  }, []);

  return (
    <div className='flex h-screen'>
      <div className="w-full h-screen">
        <Canvas>
          <color attach='background' args={['#101214']} />
          <ambientLight intensity={1} />
          <directionalLight position={[2,0,2]} intensity={1} />
          <Stars />
          <Earth />
          <OrbitControls enableZoom={true} rotateSpeed={0.30} />

          {
            satellites
              .filter((satellite) => selectedIds.includes(satellite.id))
              .map((satellite) => {
                const [_, line1, line2] = convertToTLE(satellite);
                console.log("TLE line1:", line1);
                console.log("TLE line2:", line2);
                const positions = calculateOrbitTrail(line1, line2);
                return <OrbitTrail key={satellite.id} positions={positions} />
              })
          }

        </Canvas>

        <div className={"absolute top-4 right-4"}>
          <button className={"backdrop-blur-2xl rounded-sm bg-gray-800 p-2 opacity-90 text-center font-bold text-white hover:bg-gray-500 transition flex items-center" } onClick={() => setIsMenuOpen(!isMenuOpen)}>
            {isMenuOpen ? "Close Options" : "Open Options"}
          </button>
        </div>

        {
          isMenuOpen && (
            <div className={"absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 bg-gray-900 shadow-2xl rounded-sm h-[60vh] w-[600px] flex flex-col overflow-hidden"}>
              <div className={"text-lg font-semibold p-2 text-gray-100"}>Satellite Display Options</div>
              <div className={"bg-gray-800 max-h-[80vh] m-2 overflow-y-auto scrollbar-custom"}>
                <table className={"table-auto w-full text-sm text-left text-gray-300"}>
                  <thead className={"sticky top-0 bg-gray-800 border-b border-gray-700"}>
                    <tr>
                      <th className={"p-2 text-sm text-center"}>Display</th>
                      <th className={"p-2 text-sm text-center"}>Satellite Name</th>
                      <th className={"p-2 text-sm text-center"}>NORAD</th>
                      <th className={"p-2 text-sm text-center"}>Inclination</th>
                      <th className={"p-2 text-sm text-center"}>Mean Motion</th>
                      <th className={"p-2 text-sm text-center"}>Eccentricity</th>
                    </tr>
                  </thead>
                  <tbody>
                    {satellites.map((satellite) => (
                      <tr key={satellite.id} className={"hover:bg-gray-800 text-gray-300"}>
                        <td>
                          <div className={"flex justify-center items-center"}>
                            <input
                              type="checkbox"
                              checked={selectedIds.includes(satellite.id)}
                              onChange={() => toggleSatelliteSelection(satellite.id)}
                              className={"w-3 h-3 accent-gray-500"}
                            />
                          </div>
                        </td>
                        <td className={"text-center"}>{satellite.objectName}</td>
                        <td className={"text-center"}>{satellite.noradCatId}</td>
                        <td className={"text-center"}>{satellite.inclination.toFixed(2)}</td>
                        <td className={"text-center"}>{satellite.meanMotion.toFixed(2)}</td>
                        <td className={"text-center"}>{satellite.eccentricity.toFixed(7)}</td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          )
        }
      </div>
    </div>
  )
}

export default GlobeScene;


// {
//   isMenuOpen && (
//     <div className={"absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 bg-blue-400 opacity-70 h-[60vh] w-[600px] flex flex-col justify-end"}>
//       <h2>Options</h2>
//       <div className={"bg-violet-400 h-[90%] m-2 overflow-y-auto scrollbar-custom"}>
//         <ul>
//           {satellites.map((sat) => (
//             <li key={sat.id} className={"bg-green-600 opacity-70 m-[3px]"}>
//               <input
//                 type="checkbox"
//                 checked={selectedIds.includes(sat.id)}
//                 onChange={() => toggleSatelliteSelection(sat.id)}
//               />
//               <p>{sat.objectName}</p>
//             </li>
//           ))}
//         </ul>
//       </div>
//     </div>
//   )
// }