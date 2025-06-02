import { Line } from "@react-three/drei";
import { Vector3 } from 'three';
import {getNextColour} from "../util/randomColor.ts";

interface OrbitTrailProps {
  positions: Vector3[];
  color?: string;
}

// https://drei.docs.pmnd.rs/shapes/line
export const OrbitTrail: React.FC<OrbitTrailProps> = ({ positions }) => {
  return (
    <Line
      points={positions}
      color={getNextColour()}
      lineWidth={2}
    />
  );
}

export default OrbitTrail;