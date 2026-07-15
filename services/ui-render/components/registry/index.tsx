import Container from "./layout/Container";
import TwoColumnLayout from "./layout/TwoColumnLayout";
import Card from "./layout/Card";
import Heading from "./typography/Heading";
import BuyButton from "./actions/BuyButton";
import PromoBanner from "./media/promo-banner";

export const ComponentRegistry: Record<string, React.ComponentType<any>> = {
  Container,
  TwoColumnLayout,
  Card,
  Heading,
  BuyButton,
  PromoBanner,
};
