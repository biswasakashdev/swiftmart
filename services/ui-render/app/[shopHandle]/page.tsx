import { notFound } from "next/navigation";
import { ComponentRegistry } from "@/components/registry";
import { Page, Root } from "@/types/page.types";

export default async function DynamicStorefront({
  params,
}: {
  params: { shopHandle: string };
}) {
  const storeData = await fetchComponentData(params.shopHandle);

  if (!storeData) {
    notFound();
  }

  return (
    <main style={storeData.theme.global}>
      {storeData.pages.map((block: Page) => {
        // 2. Resolve the string identifier to a hardcoded UI component
        const Component = ComponentRegistry[block.type];

        if (!Component) {
          return <div key={block.id}>Component {block.type} not found</div>;
        }

        // 3. Render it out with server-injected layout configurations and custom styling
        return (
          <div key={block.id} style={block.styles}>
            <Component {...block.props} />
          </div>
        );
      })}
    </main>
  );
}

export async function fetchComponentData(_pageId: string): Promise<Root> {
  return new Promise((res) => {
    setTimeout(() => {
      res(componentData);
    });
  });
}

export const componentData: Root = {
  title: "page_deep_nesting_2026",
  description: "A long description",
  theme: {
    global: {
      color: "#ff5722",
      backgroundColor: "#ffffff",
      fontFamily: "Inter",
    },
  },
  pages: [
    {
      id: "section_01",
      type: "Container",
      styles: {
        padding: "40px",
        backgroundColor: "#f9f9f9",
      },
      props: {
        maxWidth: "xl",
      },
      children: [
        {
          id: "grid_01",
          type: "TwoColumnLayout",
          styles: {
            gap: "24px",
            display: "grid",
            gridTemplateColumns: "1fr 1fr",
          },
          props: {},
          children: [
            {
              id: "col_left",
              type: "Card",
              styles: {
                padding: "20px",
                boxShadow: "0 4px 6px rgba(0,0,0,0.1)",
              },
              props: {
                variant: "elevated",
              },
              children: [
                {
                  id: "card_title",
                  type: "Heading",
                  styles: {
                    fontSize: "24px",
                    color: "#333",
                  },
                  props: {
                    text: "Exclusive Summer Drop",
                  },
                },
                {
                  id: "card_btn",
                  type: "BuyButton",
                  styles: {
                    marginTop: "16px",
                  },
                  props: {
                    productId: "prod_xyz",
                    label: "Unlock Early Access",
                  },
                },
              ],
            },
            {
              id: "col_right",
              type: "PromoBanner",
              styles: {
                borderRadius: "8px",
              },
              props: {
                imageUrl: "https://cdn.myclone.com/promo.jpg",
              },
            },
          ],
        },
      ],
    },
  ],
};
